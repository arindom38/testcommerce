package org.test.wsd.testcommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.test.wsd.testcommerce.repository.CustomerWishlistRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerWishlistServiceImpl implements CustomerWishlistService {
    private final CustomerWishlistRepository customerWishlistRepository;
}