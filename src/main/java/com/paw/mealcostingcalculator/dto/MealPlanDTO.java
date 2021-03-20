package com.paw.mealcostingcalculator.dto;

import com.paw.mealcostingcalculator.model.Meal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class MealPlanDTO {
    private Integer meal_plan_id;
    private Date date;
    private String username;
    private List<Meal> meals;
}
