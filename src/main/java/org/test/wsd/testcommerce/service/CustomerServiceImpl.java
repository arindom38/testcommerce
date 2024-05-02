package org.test.wsd.testcommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.wsd.testcommerce.constant.ErrorCode;
import org.test.wsd.testcommerce.dto.ItemDto;
import org.test.wsd.testcommerce.entity.Customer;
import org.test.wsd.testcommerce.entity.CustomerWishlist;
import org.test.wsd.testcommerce.exception.GenericNotFoundException;
import org.test.wsd.testcommerce.repository.CustomerRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerWishlistService customerWishlistService;
    private final ItemService itemService;

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new GenericNotFoundException(ErrorCode.ENTITY_NOT_FOUND_WITH_ID, customerId.toString()));
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<ItemDto> getCustomerWishListItemsByCustomerId(Long customerId) {
        List<Long> itemIds = customerWishlistService.findAllByCustomerId(customerId)
                .stream().filter(customerWishlist -> Boolean.FALSE.equals(customerWishlist.getIsRemoved()))
                .map(CustomerWishlist::getItemId)
                .toList();
        return itemService.findAllByIdIn(itemIds)
                .stream().map(ItemDto::new)
                .toList();
    }
}
