package com.paw.mealcostingcalculator.dtos.detailsDTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class MealShortDTO {
    private String name;
    private BigDecimal cost;
}
