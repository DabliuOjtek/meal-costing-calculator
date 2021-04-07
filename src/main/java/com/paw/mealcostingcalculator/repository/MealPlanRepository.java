package com.paw.mealcostingcalculator.repository;

import com.paw.mealcostingcalculator.model.MealPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlanEntity,Integer> {
}
