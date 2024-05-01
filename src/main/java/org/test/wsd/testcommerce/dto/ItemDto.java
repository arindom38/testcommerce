package org.test.wsd.testcommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.test.wsd.testcommerce.entity.Item;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private String itemPrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int totalSaleAmount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int totalNumberOfSale;

    public ItemDto(Item item) {
        this.itemId = item.getId();
        this.itemName = item.getName();
        this.itemDescription = item.getDescription();
        this.itemPrice = item.getPrice().toString();
    }
}
