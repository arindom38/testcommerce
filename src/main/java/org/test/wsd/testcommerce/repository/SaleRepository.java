package org.test.wsd.testcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.test.wsd.testcommerce.dto.ItemSaleAmountDto;
import org.test.wsd.testcommerce.dto.ItemSaleCountDto;
import org.test.wsd.testcommerce.entity.Sale;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT COALESCE(SUM(s.amount),0) FROM Sale s WHERE s.saleDate = :date")
    int getTotalSaleAmountByDate(LocalDate date);

    @Query("SELECT s.saleDate FROM Sale s WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY s.saleDate " +
            "ORDER BY COALESCE(SUM(s.amount), 0) DESC LIMIT 1")
    LocalDate getMaxSaleDay(LocalDate startDate, LocalDate endDate);

    @Query("SELECT new org.test.wsd.testcommerce.dto.ItemSaleAmountDto(s.itemId,COALESCE(SUM(s.amount),0)) FROM Sale s " +
            "GROUP BY s.itemId ORDER BY COALESCE(SUM(s.amount),0) DESC LIMIT :limit")
    List<ItemSaleAmountDto> getTopSellingItemsAllTime(int limit);

    @Query("SELECT new org.test.wsd.testcommerce.dto.ItemSaleCountDto(s.itemId ,COALESCE(count(s.id),0))FROM Sale s " +
            "WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY s.itemId ORDER BY count(s.id) DESC LIMIT :limit")
    List<ItemSaleCountDto> getTopSellingItemsByDateRange(int limit, LocalDate startDate, LocalDate endDate);
}
