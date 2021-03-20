package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dto.ProductBatchDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags={SpringFoxConfig.productBatch})
public class ProductBatch {

    @ApiOperation(value = "Returns list of product batches")
    @GetMapping("/product-batches")
    private ProductBatchDTO getProductBatches(){
        return ProductBatchDTO.builder().build();
    }

    @ApiOperation(value = "Returns product batch by id")
    @GetMapping("/product-batch/{id}")
    private ProductBatchDTO getProductBatch(@ApiParam(value="ID of product batch to return", example = "1", required = true) @PathVariable Integer id){
        return ProductBatchDTO.builder().build();
    }

    @ApiOperation(value = "Creates a new product batch")
    @PostMapping("/product-batches")
    private ProductBatchDTO addProductBatch(){
        return ProductBatchDTO.builder().build();
    }

    @ApiOperation(value = "Deletes a specific product batch")
    @DeleteMapping("/product-batch/{id}")
    private void deleteMeal(@ApiParam(value="Product batch's ID to delete", example = "1", required = true) @PathVariable Integer id){

    }

}

