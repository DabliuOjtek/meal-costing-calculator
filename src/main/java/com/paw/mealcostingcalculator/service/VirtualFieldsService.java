package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.model.MealEntity;
import com.paw.mealcostingcalculator.model.MealPlanEntity;
import com.paw.mealcostingcalculator.model.ProductBatchEntity;
import com.paw.mealcostingcalculator.repository.MealRepository;
import com.paw.mealcostingcalculator.repository.ProductBatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VirtualFieldsService {

    private final MealPlanService mealPlanService;
    private final ProductBatchRepository productBatchRepository;
    private final MealRepository mealRepository;

    public List<MealEntity> getUserMealsList(UserDetailsImpl userDetails) {
        Set<MealPlanEntity> userMealPlan = mealPlanService.getUserMealPlanSet(userDetails);
        List<MealEntity> mealEntityList = mealRepository.findAllByMealPlanIdIsNull();

        userMealPlan.forEach(meal -> mealEntityList.addAll(meal.getMeals()));

        return mealEntityList;
    }

    public List<ProductBatchEntity> getUserProductBatches(UserDetailsImpl userDetails) {
        List<MealEntity> mealEntityList = getUserMealsList(userDetails);
        List<ProductBatchEntity> productBatchEntityList = productBatchRepository.findAllByMealIdIsNull();

        mealEntityList.forEach(productBatch -> productBatchEntityList.addAll(productBatch.getProducts()));

        return productBatchEntityList;
    }
}
