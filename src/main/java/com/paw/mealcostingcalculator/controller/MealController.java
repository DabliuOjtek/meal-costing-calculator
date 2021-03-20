package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dto.MealDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags={SpringFoxConfig.meal})
public class MealController {

    @ApiOperation(value = "Returns list of meals")
    @GetMapping("/meals")
    private MealDTO getMeals(){
        return MealDTO.builder().build();
    }

    @ApiOperation(value = "Returns meal by id")
    @GetMapping("/meal/{id}")
    private MealDTO getMeal(@ApiParam(value="ID of meal to return", example = "1", required = true) @PathVariable Integer id){
        return MealDTO.builder().build();
    }

    @ApiOperation(value = "Creates a new meal")
    @PostMapping("/meals")
    private void addMeal(){

    }

    @ApiOperation(value = "Deletes a specific meal")
    @DeleteMapping("/meal/{id}")
    private void deleteMeal(@ApiParam(value="Meal's ID to delete", example = "1", required = true) @PathVariable Integer id){

    }
}
