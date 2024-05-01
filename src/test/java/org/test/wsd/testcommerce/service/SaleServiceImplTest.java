package org.test.wsd.testcommerce.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.test.wsd.testcommerce.dto.ItemDto;
import org.test.wsd.testcommerce.dto.ItemSaleAmountDto;
import org.test.wsd.testcommerce.dto.ItemSaleCountDto;
import org.test.wsd.testcommerce.entity.Item;
import org.test.wsd.testcommerce.repository.SaleRepository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@Tag("unit")
@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SaleServiceImplTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private SaleServiceImpl saleService;

    @Test
    void given_date_when_get_total_sale_amount_then_return_total_sale_amount() {

        Mockito.when(saleRepository.getTotalSaleAmountByDate(LocalDate.now())).thenReturn(100);
        int result = saleService.getTotalSaleAmountByDate(LocalDate.now());
        assertEquals(100, result);
    }


    @Test
    void given_date_when_get_total_sale_amount_then_return_zero_total_sale_amount() {

        Mockito.when(saleRepository.getTotalSaleAmountByDate(any())).thenReturn(0);
        int result = saleService.getTotalSaleAmountByDate(LocalDate.now());
        assertEquals(0, result);
    }

    @Test
    void given_date_range_when_get_max_sale_date_then_return_max_sale_date() {
        Mockito.when(saleRepository.getMaxSaleDay(any(), any())).thenReturn(
                LocalDate.of(2024, 4, 15));

        assertEquals(LocalDate.of(2024, 4, 15), saleService.getMaxSaleDay(any(), any()));
    }

    @Test
    void given_limit_when_get_top_selling_items_of_all_time_then_return_top_selling_items_based_on_sale_amount() {
        List<ItemSaleAmountDto> itemSaleAmountDtos = List.of(
                new ItemSaleAmountDto(1L, 500),
                new ItemSaleAmountDto(2L, 400)
        );

        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("product A");
        item1.setDescription("product A");
        item1.setPrice(BigInteger.ONE);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("product B");
        item2.setDescription("product B");
        item2.setPrice(BigInteger.TWO);

        Mockito.when(saleRepository.getTopSellingItemsAllTime(2)).thenReturn(itemSaleAmountDtos);
        Mockito.when(itemService.findById(1L)).thenReturn(item1);
        Mockito.when(itemService.findById(2L)).thenReturn(item2);

        List<ItemDto> topSellingItemsAllTime = saleService.getTopSellingItemsAllTime(2);

        assertEquals(2, topSellingItemsAllTime.size());
        assertEquals("product A", topSellingItemsAllTime.get(0).getItemName());
        assertEquals("product B", topSellingItemsAllTime.get(1).getItemName());
        assertEquals("product A", topSellingItemsAllTime.get(0).getItemDescription());
        assertEquals("product B", topSellingItemsAllTime.get(1).getItemDescription());
        assertEquals(BigInteger.ONE.toString(), topSellingItemsAllTime.get(0).getItemPrice());
        assertEquals(BigInteger.TWO.toString(), topSellingItemsAllTime.get(1).getItemPrice());
        assertEquals(500, topSellingItemsAllTime.get(0).getTotalSaleAmount());
        assertEquals(400, topSellingItemsAllTime.get(1).getTotalSaleAmount());
    }

    @Test
    void given_limit_date_range_when_get_top_selling_items_by_date_range_then_return_top_selling_items_based_on_sale_count() {
        List<ItemSaleCountDto> itemSaleCountDtos = List.of(
                new ItemSaleCountDto(1L, 500),
                new ItemSaleCountDto(2L, 400)
        );

        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("product A");
        item1.setDescription("product A");
        item1.setPrice(BigInteger.ONE);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("product B");
        item2.setDescription("product B");
        item2.setPrice(BigInteger.TWO);

        Mockito.when(saleRepository.getTopSellingItemsByDateRange(2, LocalDate.now(), LocalDate.now())).thenReturn(itemSaleCountDtos);
        Mockito.when(itemService.findById(1L)).thenReturn(item1);
        Mockito.when(itemService.findById(2L)).thenReturn(item2);

        List<ItemDto> topSellingItemsByDateRange = saleService.getTopSellingItemsByDateRange(2, LocalDate.now(), LocalDate.now());

        assertEquals(2, topSellingItemsByDateRange.size());
        assertEquals("product A", topSellingItemsByDateRange.get(0).getItemName());
        assertEquals("product B", topSellingItemsByDateRange.get(1).getItemName());
        assertEquals("product A", topSellingItemsByDateRange.get(0).getItemDescription());
        assertEquals("product B", topSellingItemsByDateRange.get(1).getItemDescription());
        assertEquals(BigInteger.ONE.toString(), topSellingItemsByDateRange.get(0).getItemPrice());
        assertEquals(BigInteger.TWO.toString(), topSellingItemsByDateRange.get(1).getItemPrice());
        assertEquals(500, topSellingItemsByDateRange.get(0).getTotalNumberOfSale());
        assertEquals(400, topSellingItemsByDateRange.get(1).getTotalNumberOfSale());
    }

}