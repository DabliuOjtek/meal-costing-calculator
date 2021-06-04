package com.paw.mealcostingcalculator.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class ProductBatchDTO{
        private Integer productBatchId;
        private String productBatchName;
        private Double amountInGrams;
        private BigDecimal cost;
        private String product;
        private String usedInMeal;
}
