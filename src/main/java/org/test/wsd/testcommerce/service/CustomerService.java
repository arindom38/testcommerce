package org.test.wsd.testcommerce.service;

import org.test.wsd.testcommerce.dto.ItemDto;
import org.test.wsd.testcommerce.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<ItemDto> getCustomerWishListItemsByCustomerId(Long customerId);

    Customer getCustomerById(Long customerId);

    Customer getCustomerByEmail(String email);

    Customer getCustomerByPhone(String phone);

    Customer saveCustomer(Customer customer);

}
