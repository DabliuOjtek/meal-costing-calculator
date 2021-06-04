package com.paw.mealcostingcalculator.dtos.saveDTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MealSaveDTO {
    private String name;
    private Integer mealPlanId;
}
