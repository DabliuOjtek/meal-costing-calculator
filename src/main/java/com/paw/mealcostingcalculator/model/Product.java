package com.paw.mealcostingcalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Product {
    private Integer product_id;
    private String name;
    private Double amount_in_grams;
    private BigDecimal product_price;
}
