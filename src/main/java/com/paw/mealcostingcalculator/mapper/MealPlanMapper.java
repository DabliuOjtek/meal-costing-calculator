package com.paw.mealcostingcalculator.mapper;

import com.paw.mealcostingcalculator.dtos.MealPlanDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.MealPlanDetailsDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.MealPlanSaveDTO;
import com.paw.mealcostingcalculator.model.MealPlanEntity;

import java.util.stream.Collectors;

public class MealPlanMapper {

    private MealPlanMapper() {
    }

    public static MealPlanDTO mapToMealPlanDTO(MealPlanEntity mealPlanEntity) {
        return MealPlanDTO.builder()
                .mealPlanId(mealPlanEntity.getMealPlanId())
                .cost(mealPlanEntity.getCost())
                .date(mealPlanEntity.getDate())
                .build();
    }

    public static MealPlanDetailsDTO mapToMealPlanDetailsDTO(MealPlanEntity mealPlanEntity) {
        return MealPlanDetailsDTO.builder()
                .mealPlanId(mealPlanEntity.getMealPlanId())
                .date(mealPlanEntity.getDate())
                .cost(mealPlanEntity.getCost())
                .meals(mealPlanEntity.getMeals().stream()
                        .map(MealMapper::mapToMealShortDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public static MealPlanEntity mapToMealPlanSaveDTO(MealPlanSaveDTO mealPlanSaveDTO) {
        MealPlanEntity mealPlanEntity = new MealPlanEntity();

        mealPlanEntity.setDate(mealPlanSaveDTO.getDate());

        return mealPlanEntity;
    }
}
