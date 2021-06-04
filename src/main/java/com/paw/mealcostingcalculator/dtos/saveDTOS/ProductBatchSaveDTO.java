package com.paw.mealcostingcalculator.dtos.saveDTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ProductBatchSaveDTO {
    private String name;
    private Double amountInGrams;
    private Integer productId;
    private Integer mealId;
}
