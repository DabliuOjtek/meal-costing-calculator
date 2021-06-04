package com.paw.mealcostingcalculator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name="product_batch")
public class ProductBatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productBatchId;
    private String name;
    private Double amountInGrams;
    private BigDecimal cost;
    private Integer productId;
    private Integer mealId;
}
