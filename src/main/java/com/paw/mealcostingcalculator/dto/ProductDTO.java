package com.paw.mealcostingcalculator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class ProductDTO {
    private Integer productId;
    private String name;
    private Double amountInGrams;
    private BigDecimal price;
}
