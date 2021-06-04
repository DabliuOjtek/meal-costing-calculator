package com.paw.mealcostingcalculator.mapper;

import com.paw.mealcostingcalculator.dtos.MealDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.MealDetailsDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.MealShortDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.MealSaveDTO;
import com.paw.mealcostingcalculator.model.MealEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MealMapper {

    private MealMapper() {
    }

    public static List<MealDTO> mapToMealDTOS(List<MealEntity> meals) {
        return meals.stream()
                .map(MealMapper::mapToMealDTO)
                .collect(Collectors.toList());
    }

    public static MealDTO mapToMealDTO(MealEntity mealEntity) {
        return MealDTO.builder()
                .mealId(mealEntity.getMealId())
                .name(mealEntity.getName())
                .cost(mealEntity.getCost())
                .mealPlanId(mealEntity.getMealPlanId())
                .build();
    }

    public static MealDetailsDTO mapToMealDetailsDTO(MealEntity mealEntity, LocalDate mealPlanDate) {
        return MealDetailsDTO.builder()
                .mealId(mealEntity.getMealId())
                .name(mealEntity.getName())
                .cost(mealEntity.getCost())
                .mealPlanId(mealEntity.getMealPlanId())
                .mealPlanDate(mealPlanDate)
                .productBatches(mealEntity.getProducts().stream()
                        .map(ProductBatchMapper::mapToProductBatchShortDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public static MealShortDTO mapToMealShortDTO(MealEntity mealEntity) {
        return MealShortDTO.builder()
                .name(mealEntity.getName())
                .cost(mealEntity.getCost())
                .build();
    }

    public static MealEntity mapToMealSaveDTO(MealSaveDTO mealSaveDTO) {
        MealEntity mealEntity = new MealEntity();

        mealEntity.setName(mealSaveDTO.getName());
        mealEntity.setMealPlanId(mealSaveDTO.getMealPlanId());

        return mealEntity;
    }
}
