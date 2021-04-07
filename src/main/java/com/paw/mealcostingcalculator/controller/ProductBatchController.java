package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dto.ProductBatchDTO;
import com.paw.mealcostingcalculator.model.ProductBatchEntity;
import com.paw.mealcostingcalculator.service.ProductBatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags={SpringFoxConfig.productBatch})
public class ProductBatchController {

    private final ProductBatchService productBatchService;

    @ApiOperation(value = "Returns list of product batches")
    @GetMapping("/product-batches")
    private List<ProductBatchDTO> getProductBatches(){
        return productBatchService.getAllProductBatches();
    }

    @ApiOperation(value = "Returns product batch by id")
    @GetMapping("/product-batch/{id}")
    private ProductBatchDTO getProductBatch(@ApiParam(value="ID of product batch to return", example = "1", required = true) @PathVariable Integer id){
        return productBatchService.getSingleProductBatch(id);
    }

    @ApiOperation(value = "Creates a new product batch")
    @PostMapping("/product-batches")
    private ProductBatchEntity addProductBatch(@RequestBody ProductBatchEntity productBatch){
        return productBatchService.addProductBatch(productBatch);
    }

    @ApiOperation(value = "Deletes a specific product batch")
    @DeleteMapping("/product-batch/{id}")
    private void deleteProductBatch(@ApiParam(value="Product batch's ID to delete", example = "1", required = true) @PathVariable Integer id){
        productBatchService.deleteProductBatch(id);
    }

}

