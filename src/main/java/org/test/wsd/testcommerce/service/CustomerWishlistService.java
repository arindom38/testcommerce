package org.test.wsd.testcommerce.service;

import org.test.wsd.testcommerce.entity.CustomerWishlist;

import java.util.List;

public interface CustomerWishlistService {
    CustomerWishlist save(CustomerWishlist customerWishlist);

    List<CustomerWishlist> findAllByCustomerId(Long customerId);

    CustomerWishlist findByCustomerIdAndItemId(Long customerId, Long itemId);
}
