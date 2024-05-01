package org.test.wsd.testcommerce.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.test.wsd.testcommerce.dto.ItemDto;
import org.test.wsd.testcommerce.entity.CustomerWishlist;
import org.test.wsd.testcommerce.entity.Item;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Tag("unit")
@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerWishlistService customerWishlistService;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void given_customer_id_when_get_customer_wishlist_items_then_return_wishlist_items() {
        Long customerId = 1L;

        List<CustomerWishlist> customerWishlistList = getCustomerWishlists(customerId);

        List<Long> itemIds = new ArrayList<>();
        itemIds.add(1L);
        itemIds.add(2L);

        List<Item> items = getItems();

        when(customerWishlistService.findAllByCustomerId(customerId)).thenReturn(customerWishlistList);
        when(itemService.findAllByIdIn(itemIds)).thenReturn(items);

        List<ItemDto> result = customerService.getCustomerWishListItemsByCustomerId(customerId);

        // Add assertions based on the expected behavior of the method
        assertEquals(2, result.size());
        assertEquals("product A", result.get(0).getItemName());
        assertEquals("product B", result.get(1).getItemName());
    }

    @Test
    void given_customer_id_when_get_customer_wishlist_items_then_return_empty_wishlist_items() {
        Long customerId = 1L;
        List<Long> itemIds = new ArrayList<>();
        when(customerWishlistService.findAllByCustomerId(customerId)).thenReturn(new ArrayList<>());
        when(itemService.findAllByIdIn(itemIds)).thenReturn(new ArrayList<>());

        List<ItemDto> result = customerService.getCustomerWishListItemsByCustomerId(customerId);

        // Add assertions based on the expected behavior of the method
        assertEquals(0, result.size());
    }

    private static List<Item> getItems() {

        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setId(1L);
        item.setName("product A");
        item.setPrice(BigInteger.ONE);

        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("product B");
        item1.setPrice(BigInteger.ONE);

        items.add(item);
        items.add(item1);

        return items;
    }

    private static List<CustomerWishlist> getCustomerWishlists(Long customerId) {
        List<CustomerWishlist> customerWishlistList = new ArrayList<>();

        CustomerWishlist customerWishlist = new CustomerWishlist();

        customerWishlist.setCustomerId(customerId);
        customerWishlist.setItemId(1L);
        customerWishlist.setIsRemoved(false);

        CustomerWishlist customerWishlist1 = new CustomerWishlist();

        customerWishlist1.setCustomerId(customerId);
        customerWishlist1.setItemId(2L);
        customerWishlist1.setIsRemoved(false);


        customerWishlistList.add(customerWishlist);
        customerWishlistList.add(customerWishlist1);
        return customerWishlistList;
    }

}