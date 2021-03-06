package com.paw.mealcostingcalculator.repository;

import com.paw.mealcostingcalculator.model.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Integer> {
    List<MealEntity> findAllByMealPlanIdIsNull();
}
