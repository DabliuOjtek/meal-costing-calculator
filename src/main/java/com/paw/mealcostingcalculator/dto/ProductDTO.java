package com.paw.mealcostingcalculator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class ProductDTO {
    private Integer product_id;
    private String name;
    private Double amount_in_grams;
    private BigDecimal product_price;
}
