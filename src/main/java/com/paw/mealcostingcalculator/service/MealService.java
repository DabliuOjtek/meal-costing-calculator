package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.dto.MealDTO;
import com.paw.mealcostingcalculator.model.MealEntity;
import com.paw.mealcostingcalculator.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

    public List<MealDTO> getAllMeals() {
        return null;
    }

    public MealDTO getSingleMeal(Integer id) {
        return null;
    }

    public MealEntity addMeal(MealEntity meal) {
        return mealRepository.save(meal);
    }

    public void deleteMeal(Integer id) {
        mealRepository.deleteById(id);
    }
}
