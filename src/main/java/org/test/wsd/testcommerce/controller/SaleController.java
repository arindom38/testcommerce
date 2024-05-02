package org.test.wsd.testcommerce.controller;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.wsd.testcommerce.constant.ErrorCode;
import org.test.wsd.testcommerce.dto.ItemDto;
import org.test.wsd.testcommerce.exception.GenericValidationException;
import org.test.wsd.testcommerce.service.SaleService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping(value = "/api/sales",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/total-amount")
    public int getTotalSaleAmountByDate(@RequestParam
                                        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return saleService.getTotalSaleAmountByDate(date);
    }

    @GetMapping("/max-sale-date")
    public LocalDate getMaxSaleDate(@RequestParam
                                    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                    @RequestParam
                                    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return saleService.getMaxSaleDay(startDate, endDate);
    }

    @GetMapping("/top-items")
    public ResponseEntity<List<ItemDto>> getTopSellingItemsOfLastMonth(@RequestParam @NotNull int limit,
                                                                       @RequestParam @NotEmpty String criteria,
                                                                       @RequestParam(required = false) String month) {
        List<ItemDto> topSellingItems;
        if (criteria.equals("total-sale-amount") && month == null) {
            topSellingItems = saleService.getTopSellingItemsAllTime(limit);
            return ResponseEntity.ok(topSellingItems);
        }
        if (criteria.equals("total-number-sales") && month != null && month.equals("last")) {
            topSellingItems = saleService.getTopSellingItemsOfLastMonth(limit);
            return ResponseEntity.ok(topSellingItems);
        }
        throw new GenericValidationException(ErrorCode.INVALID_VALUE_FOR_REQUEST_PARAMS, null, null);
    }
}
