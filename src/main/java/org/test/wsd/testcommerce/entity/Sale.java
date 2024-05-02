package org.test.wsd.testcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.test.wsd.testcommerce.constant.ErrorCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "sale")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale extends BaseEntity {
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private Long itemId;
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private LocalDate saleDate;
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private int amount;

}
