package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dtos.MealDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.MealDetailsDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.MealSaveDTO;
import com.paw.mealcostingcalculator.service.MealService;
import com.paw.mealcostingcalculator.service.UserDetailsImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {SpringFoxConfig.meal})
public class MealController {

    private final MealService mealService;

    @ApiOperation(value = "Returns list of meals")
    @GetMapping("/meals")
    private List<MealDTO> getAllMeals(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mealService.getAllMeals(userDetails);
    }

    @ApiOperation(value = "Returns meal by id")
    @GetMapping("/meal/{id}")
    private MealDetailsDTO getSingleMeal(@ApiParam(value = "ID of meal to return", example = "1", required = true) @PathVariable Integer id,
                                         @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mealService.getSingleMeal(id, userDetails);
    }

    @ApiOperation(value = "Creates a new meal")
    @PostMapping("/meals")
    private void addMeal(@RequestBody MealSaveDTO mealSaveDTO) {
        mealService.addMeal(mealSaveDTO);
    }

    @ApiOperation(value = "Updates a specific meal")
    @PutMapping("/meal/{id}")
    private void updateMeal(@ApiParam(value = "Meal's ID to update", example = "1", required = true) @PathVariable Integer id,
                            @AuthenticationPrincipal UserDetailsImpl userDetail, @RequestBody MealSaveDTO mealSaveDTO ) {
        mealService.updateMeal(id,mealSaveDTO, userDetail);
    }

    @ApiOperation(value = "Deletes a specific meal")
    @DeleteMapping("/meal/{id}")
    private void deleteMeal(@ApiParam(value = "Meal's ID to delete", example = "1", required = true) @PathVariable Integer id,
                            @AuthenticationPrincipal UserDetailsImpl userDetail) {
        mealService.deleteMeal(id, userDetail);
    }
}
