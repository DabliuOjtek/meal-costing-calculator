package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dto.MealPlanDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags={SpringFoxConfig.mealPlan})
public class MealPlanController {

    @ApiOperation(value = "Returns list of meal plans")
    @GetMapping("/meal-plans")
    private MealPlanDTO getMealPlans(){
        return MealPlanDTO.builder().build();
    }

    @ApiOperation(value = "Returns meal plan from a specific date")
    @GetMapping("/meal-plan/{date}")
    private MealPlanDTO getParticularMealPlanDay(@ApiParam(value="Date of meal plan to return", example = "1", required = true) @PathVariable Integer date){
        return MealPlanDTO.builder().build();
    }

    @ApiOperation(value = "Creates a new meal plan")
    @PostMapping("/meal-plans")
    private MealPlanDTO addMealPlans(){
        return MealPlanDTO.builder().build();
    }

    @ApiOperation(value = "Deletes a specific meal plan")
    @DeleteMapping("/meal-plan/{date}")
    private void deleteParticularMealPlanDay(@ApiParam(value="Meal plan's ID to delete", example = "1", required = true) @PathVariable Integer date){

    }
}
