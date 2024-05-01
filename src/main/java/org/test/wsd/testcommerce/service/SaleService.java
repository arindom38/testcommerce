package org.test.wsd.testcommerce.service;

import org.test.wsd.testcommerce.dto.ItemDto;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {
    int getTotalSaleAmountByDate(LocalDate date);

    LocalDate getMaxSaleDay(LocalDate startDate, LocalDate endDate);

    List<ItemDto> getTopSellingItemsAllTime(int limit);

    List<ItemDto> getTopSellingItemsByDateRange(int limit, LocalDate startDate, LocalDate endDate);

}
