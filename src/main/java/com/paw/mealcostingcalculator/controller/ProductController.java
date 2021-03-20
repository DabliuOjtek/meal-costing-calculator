package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dto.ProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags={SpringFoxConfig.product})
public class ProductController {

    @ApiOperation(value = "Returns list of products")
    @GetMapping("/products")
    private ProductDTO getProducts(){
        return ProductDTO.builder().build();
    }

    @ApiOperation(value = "Returns product by id")
    @GetMapping("/products/{id}")
    private ProductDTO getProduct(@ApiParam(value="ID of product to return", example = "1", required = true) @PathVariable Integer id){
        return ProductDTO.builder().build();
    }

    @ApiOperation(value = "Creates a new product")
    @PostMapping("products")
    private void addProduct(){

    }

    @ApiOperation(value = "Deletes a specific product")
    @DeleteMapping("/products/{id}")
    private void deleteProduct(@ApiParam(value="Product's ID to delete", example = "1", required = true) @PathVariable Integer id){

    }
}
