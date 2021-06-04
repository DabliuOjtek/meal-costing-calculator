package com.paw.mealcostingcalculator.mapper;


import com.paw.mealcostingcalculator.dtos.ProductBatchDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.ProductBatchSaveDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.ProductBatchShortDTO;
import com.paw.mealcostingcalculator.model.ProductBatchEntity;

import java.util.List;
import java.util.stream.Collectors;


public class ProductBatchMapper {

    private ProductBatchMapper() {
    }

    public static List<ProductBatchDTO> mapToProductBatchDTOS(List<ProductBatchEntity> productBatches) {
        return productBatches.stream()
                .map(ProductBatchMapper::mapToProductBatch)
                .collect(Collectors.toList());
    }

    public static ProductBatchDTO mapToProductBatchDTO(ProductBatchEntity productBatchEntity, String productName, String mealName) {
        return ProductBatchDTO.builder()
                .productBatchId(productBatchEntity.getProductBatchId())
                .amountInGrams(productBatchEntity.getAmountInGrams())
                .cost(productBatchEntity.getCost())
                .product(productName)
                .usedInMeal(mealName)
                .build();
    }

    public static ProductBatchDTO mapToProductBatch(ProductBatchEntity productBatchEntity) {
        String productId = String.valueOf(productBatchEntity.getProductId());
        String mealId = String.valueOf(productBatchEntity.getMealId());

        return ProductBatchDTO.builder()
                .productBatchId(productBatchEntity.getProductBatchId())
                .productBatchName(productBatchEntity.getName())
                .amountInGrams(productBatchEntity.getAmountInGrams())
                .cost(productBatchEntity.getCost())
                .product(productId)
                .usedInMeal(mealId)
                .build();
    }

    public static ProductBatchShortDTO mapToProductBatchShortDTO(ProductBatchEntity productBatchEntity) {
        return ProductBatchShortDTO.builder()
                .name(productBatchEntity.getName())
                .amountInGrams(productBatchEntity.getAmountInGrams())
                .cost(productBatchEntity.getCost())
                .build();
    }

    public static ProductBatchEntity mapToProductBatchSaveDTO(ProductBatchSaveDTO productBatchSaveDTO) {
        ProductBatchEntity productBatchEntity = new ProductBatchEntity();

        productBatchEntity.setName(productBatchSaveDTO.getName());
        productBatchEntity.setAmountInGrams(productBatchSaveDTO.getAmountInGrams());
        productBatchEntity.setProductId(productBatchSaveDTO.getProductId());
        productBatchEntity.setMealId(productBatchSaveDTO.getMealId());

        return productBatchEntity;
    }

}
