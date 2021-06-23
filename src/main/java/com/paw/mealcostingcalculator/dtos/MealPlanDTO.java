package com.paw.mealcostingcalculator.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder
public class MealPlanDTO {
    private Integer mealPlanId;
    private LocalDate date;
    private BigDecimal cost;
}
