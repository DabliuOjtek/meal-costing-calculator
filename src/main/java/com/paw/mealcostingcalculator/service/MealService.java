package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.dtos.MealDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.MealDetailsDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.MealSaveDTO;
import com.paw.mealcostingcalculator.mapper.MealMapper;
import com.paw.mealcostingcalculator.model.MealEntity;;
import com.paw.mealcostingcalculator.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final MealPlanService mealPlanService;
    private final VirtualFieldsService virtualFieldsService;

    public List<MealDTO> getAllMeals(UserDetailsImpl userDetails) {
        List<MealEntity> mealEntityList = virtualFieldsService.getUserMealsList(userDetails);
        return MealMapper.mapToMealDTOS(mealEntityList);
    }

    public MealDetailsDTO getSingleMeal(Integer id, UserDetailsImpl userDetails) {
        MealEntity mealEntity = getMealById(id);
        LocalDate mealPlanDate = null;

        if (mealEntity.getMealPlanId() != null) {
             mealPlanDate = mealPlanService.getMealPlanDate(mealEntity.getMealPlanId());
        }

        List<MealEntity> mealEntityList = virtualFieldsService.getUserMealsList(userDetails);

        if (mealEntityList.contains(mealEntity)) {
            return MealMapper.mapToMealDetailsDTO(mealEntity, mealPlanDate);
        } else {
            throw new NoSuchElementException("The meal you are looking for, does not belong to the user");
        }
    }

    @Transactional
    public void addMeal(MealSaveDTO meal) {
        MealEntity mealEntity = MealMapper.mapToMealSaveDTO(meal);

        if (!mealEntity.getName().isEmpty()) {
            mealEntity.setCost(BigDecimal.ZERO);

            mealRepository.save(mealEntity);
        } else {
            throw new IllegalArgumentException("Parameter cannot be empty");
        }
    }

    public void deleteMeal(Integer id, UserDetailsImpl userDetails) {
        MealEntity mealEntity = getMealById(id);
        List<MealEntity> mealEntityList = virtualFieldsService.getUserMealsList(userDetails);

        if (mealEntityList.contains(mealEntity)) {
            mealRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("The meal you are looking for, does not belong to the user");
        }
    }

    public String getMealName(Integer id) {
        if (id != null) {
            MealEntity mealEntity = getMealById(id);
            return mealEntity.getName();
        } else {
            return "Not used in any meal";
        }
    }

    public void updateMealCost(Integer id, BigDecimal newProductBatchCost) {
        MealEntity mealEntity = getMealById(id);
        Integer mealPlanId = mealEntity.getMealPlanId();
        BigDecimal currentCost = mealEntity.getCost();
        BigDecimal newCost = currentCost.add(newProductBatchCost);

        mealEntity.setCost(newCost);
        mealRepository.save(mealEntity);

        if (mealPlanId != null) {
            mealPlanService.updateMealPlanCost(mealPlanId, newProductBatchCost);
        }
    }

    private MealEntity getMealById(Integer id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cannot find any meal from given id"));
    }


}
