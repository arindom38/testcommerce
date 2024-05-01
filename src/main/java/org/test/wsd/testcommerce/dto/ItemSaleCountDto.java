package org.test.wsd.testcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemSaleCountDto {
    private Long id;
    private int totalNumberOfSale;
}
