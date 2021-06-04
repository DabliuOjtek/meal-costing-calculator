package com.paw.mealcostingcalculator.dtos;

import com.paw.mealcostingcalculator.model.MealEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
public class MealPlanDTO {
    private Integer mealPlanId;
    private LocalDate date;
    private BigDecimal cost;
    private List<MealEntity> mealEntities;
}
