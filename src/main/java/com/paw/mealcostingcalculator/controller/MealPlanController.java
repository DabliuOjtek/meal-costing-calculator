package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dtos.MealPlanDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.MealPlanDetailsDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.MealPlanSaveDTO;
import com.paw.mealcostingcalculator.service.MealPlanService;
import com.paw.mealcostingcalculator.service.UserDetailsImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {SpringFoxConfig.mealPlan})
public class MealPlanController {

    private final MealPlanService mealPlanService;

    @ApiOperation(value = "Returns list of meal plans")
    @GetMapping("/meal-plans")
    private List<MealPlanDTO> getMealPlans(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mealPlanService.getAllMealsPlan(userDetails);
    }

    @ApiOperation(value = "Returns meal plan from a specific date")
    @GetMapping("/meal-plan/{date}")
    private MealPlanDetailsDTO getParticularMealPlanDay(@ApiParam(value = "Date of meal plan to return", example = "1", required = true)
                                                        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                        @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mealPlanService.getParticularMealPlanDay(date, userDetails);
    }

    @ApiOperation(value = "Creates a new meal plan")
    @PostMapping("/meal-plans")
    private void addMealPlans(@RequestBody MealPlanSaveDTO mealPlanSaveDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        mealPlanService.addMealPlan(mealPlanSaveDTO, userDetails);
    }

    @ApiOperation(value = "Updates a specific specific meal plan")
    @PutMapping("/meal-plan")
    private void updateMealPlan(@ApiParam(value = "Date of meal plan to return", example = "1", required = true)
                                @RequestBody MealPlanDTO mealPlanDTO) {
        mealPlanService.updateMealPlan(mealPlanDTO);
    }


    @ApiOperation(value = "Deletes a specific meal plan")
    @DeleteMapping("/meal-plan/{date}")
    private void deleteParticularMealPlanDay(@ApiParam(value = "Meal plan's ID to delete", example = "1", required = true)
                                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        mealPlanService.deleteParticularMealPlanDay(date, userDetails);
    }
}
