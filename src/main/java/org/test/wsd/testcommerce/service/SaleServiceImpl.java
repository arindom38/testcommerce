package org.test.wsd.testcommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.test.wsd.testcommerce.dto.ItemDto;
import org.test.wsd.testcommerce.dto.ItemSaleAmountDto;
import org.test.wsd.testcommerce.dto.ItemSaleCountDto;
import org.test.wsd.testcommerce.entity.Item;
import org.test.wsd.testcommerce.repository.SaleRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ItemService itemService;

    @Override
    public int getTotalSaleAmountByDate(LocalDate date) {
        return saleRepository.getTotalSaleAmountByDate(date);
    }

    @Override
    public LocalDate getMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        return saleRepository.getMaxSaleDay(startDate, endDate);
    }

    @Override
    public List<ItemDto> getTopSellingItemsAllTime(int limit) {
        List<ItemSaleAmountDto> itemSaleAmountDtos = saleRepository.getTopSellingItemsAllTime(limit);
        return itemSaleAmountDtos.stream().map(itemSaleAmountDto -> {
            Item saledItem = itemService.findById(itemSaleAmountDto.getId());
            return ItemDto.builder()
                    .itemId(saledItem.getId())
                    .itemDescription(saledItem.getDescription())
                    .itemName(saledItem.getName())
                    .itemPrice(saledItem.getPrice().toString())
                    .totalSaleAmount(itemSaleAmountDto.getTotalSaleAmount())
                    .build();
        }).toList();
    }

    @Override
    public List<ItemDto> getTopSellingItemsByDateRange(int limit, LocalDate startDate, LocalDate endDate) {
        List<ItemSaleCountDto> itemSaleCountDtos = saleRepository.getTopSellingItemsByDateRange(limit, startDate, endDate);
        return itemSaleCountDtos.stream().map(itemSaleCountDto -> {
            Item saledItem = itemService.findById(itemSaleCountDto.getId());
            return ItemDto.builder()
                    .itemId(saledItem.getId())
                    .itemDescription(saledItem.getDescription())
                    .itemName(saledItem.getName())
                    .itemPrice(saledItem.getPrice().toString())
                    .totalNumberOfSale(itemSaleCountDto.getTotalNumberOfSale())
                    .build();
        }).toList();
    }
}
