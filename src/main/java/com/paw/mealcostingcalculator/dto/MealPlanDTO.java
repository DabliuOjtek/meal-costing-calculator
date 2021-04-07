package com.paw.mealcostingcalculator.dto;

import com.paw.mealcostingcalculator.model.MealEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class MealPlanDTO {
    private Integer mealPlanId;
    private Date date;
    private String username;
    private List<MealEntity> mealEntities;
}
