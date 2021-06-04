package com.paw.mealcostingcalculator.dtos.detailsDTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ProductBatchShortDTO {
    private String name;
    private Double amountInGrams;
    private BigDecimal cost;
}
