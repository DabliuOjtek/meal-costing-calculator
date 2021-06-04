package com.paw.mealcostingcalculator.dtos.saveDTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
public class ProductSaveDTO {
    private String name;
    private Double amountInGrams;
    private BigDecimal price;
}
