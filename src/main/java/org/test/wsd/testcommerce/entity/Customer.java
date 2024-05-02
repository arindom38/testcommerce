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
@Table(name = "customer")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer  extends BaseEntity {

    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private String name;
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private String email;
    @NotNull(message = ErrorCode.FILED_SHOULD_NOT_BE_NULL)
    private String phone;
    private String address;
}
