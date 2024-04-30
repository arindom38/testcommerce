package org.test.wsd.testcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "customer_wishlist")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerWishlist extends BaseEntity{
    private Long customerId;
    private Long itemId;
    private Boolean isRemoved;
}
