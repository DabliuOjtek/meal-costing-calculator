package com.paw.mealcostingcalculator.mapper;

import com.paw.mealcostingcalculator.dto.ProductDTO;
import com.paw.mealcostingcalculator.model.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static List<ProductDTO> mapToProductDTOS(List<ProductEntity> products){
        return products.stream()
                .map(product -> mapToProductDTO(product))
                .collect(Collectors.toList());
    }

    public static ProductDTO mapToProductDTO(ProductEntity product){
        return ProductDTO.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .amountInGrams(product.getAmountInGrams())
                .price(product.getPrice())
                .build();
    }
}
