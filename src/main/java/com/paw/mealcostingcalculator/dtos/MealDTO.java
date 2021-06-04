package com.paw.mealcostingcalculator.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class MealDTO {
    private Integer mealId;
    private String name;
    private BigDecimal cost;
    private Integer mealPlanId;
}
