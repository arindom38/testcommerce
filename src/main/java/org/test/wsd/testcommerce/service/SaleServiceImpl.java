package org.test.wsd.testcommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.test.wsd.testcommerce.repository.SaleRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
}
