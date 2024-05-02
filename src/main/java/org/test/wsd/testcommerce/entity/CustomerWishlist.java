package org.test.wsd.testcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.test.wsd.testcommerce.constant.ErrorCode;

@Data
@Entity
@Table(name = "customer_wishlist")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerWishlist extends BaseEntity{
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private Long customerId;
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private Long itemId;
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private Boolean isRemoved;
}
