package org.test.wsd.testcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemSaleAmountDto {
    private Long id;
    private int totalSaleAmount;
}
