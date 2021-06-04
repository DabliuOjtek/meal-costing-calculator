package com.paw.mealcostingcalculator.mapper;

import com.paw.mealcostingcalculator.dtos.ProductDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.ProductSaveDTO;
import com.paw.mealcostingcalculator.model.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    private ProductMapper() {
    }

    public static List<ProductDTO> mapToProductDTOS(List<ProductEntity> products) {
        return products.stream()
                .map(ProductMapper::mapToProductDTO)
                .collect(Collectors.toList());
    }

    public static ProductDTO mapToProductDTO(ProductEntity productEntity) {
        return ProductDTO.builder()
                .productId(productEntity.getProductId())
                .name(productEntity.getName())
                .amountInGrams(productEntity.getAmountInGrams())
                .price(productEntity.getPrice())
                .build();
    }

    public static ProductEntity mapToProductSaveDTO(ProductSaveDTO productSaveDTO) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productSaveDTO.getName());
        productEntity.setAmountInGrams(productSaveDTO.getAmountInGrams());
        productEntity.setPrice(productSaveDTO.getPrice());

        return productEntity;
    }
}
