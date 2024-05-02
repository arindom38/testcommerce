package org.test.wsd.testcommerce.controller;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.wsd.testcommerce.dto.ItemDto;
import org.test.wsd.testcommerce.service.CustomerService;

import java.util.List;


@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping(value = "/api/customers",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/wish-list")
    public List<ItemDto> getWishListByCustomer(@RequestParam @NotNull Long customerId) {
        return customerService.getCustomerWishListItemsByCustomerId(customerId);
    }
}
