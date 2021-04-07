package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dto.ProductDTO;
import com.paw.mealcostingcalculator.model.ProductEntity;
import com.paw.mealcostingcalculator.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags={SpringFoxConfig.product})
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "Returns list of products")
    @GetMapping("/products")
    private List<ProductDTO> getProducts(){
        return productService.getAllProducts();
    }

    @ApiOperation(value = "Returns product by id")
    @GetMapping("/products/{id}")
    private ProductDTO getProduct(@ApiParam(value="ID of product to return", example = "1", required = true) @PathVariable Integer id){
        return productService.getSingleProduct(id);
    }

    @ApiOperation(value = "Creates a new product")
    @PostMapping("/products")
    private ProductEntity addProduct(@RequestBody ProductEntity product){
        return productService.addProduct(product);
    }

    @ApiOperation(value = "Deletes a specific product")
    @DeleteMapping("/products/{id}")
    private void deleteProduct(@ApiParam(value="Product's ID to delete", example = "1", required = true) @PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
