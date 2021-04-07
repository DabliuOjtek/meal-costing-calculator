package com.paw.mealcostingcalculator.dto;

import com.paw.mealcostingcalculator.model.MealEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Builder
public class ProductBatchDTO{
        private Integer productBatchId;
        private Double amountInGrams;
        private BigDecimal cost;
        private String productName;
        private List<MealEntity> usedInMeals;
}
