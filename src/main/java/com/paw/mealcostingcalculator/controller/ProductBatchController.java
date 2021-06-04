package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dtos.ProductBatchDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.ProductBatchSaveDTO;
import com.paw.mealcostingcalculator.service.ProductBatchService;
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
@Api(tags={SpringFoxConfig.productBatch})
public class ProductBatchController {

    private final ProductBatchService productBatchService;

    @ApiOperation(value = "Returns list of product batches")
    @GetMapping("/product-batches")
    private List<ProductBatchDTO> getProductBatches(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return productBatchService.getAllProductBatches(userDetails);
    }

    @ApiOperation(value = "Returns product batch by id")
    @GetMapping("/product-batch/{id}")
    private ProductBatchDTO getProductBatch(@ApiParam(value="ID of product batch to return", example = "1", required = true) @PathVariable Integer id,
                                            @AuthenticationPrincipal UserDetailsImpl userDetails){
        return productBatchService.getSingleProductBatch(id, userDetails);
    }

    @ApiOperation(value = "Creates a new product batch")
    @PostMapping("/product-batches")
    private void addProductBatch(@RequestBody ProductBatchSaveDTO productBatchSaveDTO){
        productBatchService.addProductBatch(productBatchSaveDTO);
    }

    @ApiOperation(value = "Deletes a specific product batch")
    @DeleteMapping("/product-batch/{id}")
    private void deleteProductBatch(@ApiParam(value="Product batch's ID to delete", example = "1", required = true) @PathVariable Integer id,
                                    @AuthenticationPrincipal UserDetailsImpl userDetail){
        productBatchService.deleteProductBatch(id,userDetail);
    }

}

