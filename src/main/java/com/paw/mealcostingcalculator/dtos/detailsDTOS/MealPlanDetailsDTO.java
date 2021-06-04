package com.paw.mealcostingcalculator.dtos.detailsDTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
public class MealPlanDetailsDTO {
    private Integer mealPlanId;
    private LocalDate date;
    private BigDecimal cost;
    private List<MealShortDTO> meals;
}
