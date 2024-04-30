package org.test.wsd.testcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "customer")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer  extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    private String address;
}
