package com.paw.mealcostingcalculator.repository;

import com.paw.mealcostingcalculator.model.MealPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlanEntity, Integer> {
    MealPlanEntity findByDate(LocalDate date);
    void deleteByDate(LocalDate date);
}
