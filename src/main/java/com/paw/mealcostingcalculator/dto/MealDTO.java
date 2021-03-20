package com.paw.mealcostingcalculator.dto;

import com.paw.mealcostingcalculator.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class MealDTO {
    private Integer id;
    private String name;
    private List<Product> products;
}
