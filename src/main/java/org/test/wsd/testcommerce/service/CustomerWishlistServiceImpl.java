package org.test.wsd.testcommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.wsd.testcommerce.entity.CustomerWishlist;
import org.test.wsd.testcommerce.repository.CustomerWishlistRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerWishlistServiceImpl implements CustomerWishlistService {
    private final CustomerWishlistRepository customerWishlistRepository;

    @Override
    @Transactional
    public CustomerWishlist save(CustomerWishlist customerWishlist) {
        return customerWishlistRepository.save(customerWishlist);
    }

    @Override
    public List<CustomerWishlist> findAllByCustomerId(Long customerId) {
        return customerWishlistRepository.findAllByCustomerId(customerId);
    }

    @Override
    public CustomerWishlist findByCustomerIdAndItemId(Long customerId, Long itemId) {
        return customerWishlistRepository.findByCustomerIdAndItemId(customerId, itemId);
    }

}
