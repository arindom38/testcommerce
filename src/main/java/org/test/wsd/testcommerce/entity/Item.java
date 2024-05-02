package org.test.wsd.testcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.test.wsd.testcommerce.constant.ErrorCode;

import java.math.BigInteger;

@Data
@Entity
@Table(name = "item")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item extends BaseEntity{
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private String name;
    private String description;
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private BigInteger price;
}
