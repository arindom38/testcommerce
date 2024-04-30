package org.test.wsd.testcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "sale")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private LocalDate saleDate;

    private double amount;

    private int quantity;
}
