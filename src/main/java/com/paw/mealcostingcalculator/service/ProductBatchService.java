package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.dtos.ProductBatchDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.ProductBatchSaveDTO;
import com.paw.mealcostingcalculator.mapper.ProductBatchMapper;
import com.paw.mealcostingcalculator.model.ProductBatchEntity;
import com.paw.mealcostingcalculator.repository.ProductBatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductBatchService {

    private final ProductBatchRepository productBatchRepository;
    private final ProductService productService;
    private final MealService mealService;
    private final VirtualFieldsService virtualFieldsService;

    public List<ProductBatchDTO> getAllProductBatches(UserDetailsImpl userDetails) {
        List<ProductBatchEntity> ProductBatchList = virtualFieldsService.getUserProductBatches(userDetails);
        return ProductBatchMapper.mapToProductBatchDTOS(ProductBatchList);
    }

    public ProductBatchDTO getSingleProductBatch(Integer id, UserDetailsImpl userDetails) {
        ProductBatchEntity productBatchEntity = getProductBatchEntity(id);
        String productName = productService.getProductName(productBatchEntity.getProductId());
        String mealName = mealService.getMealName(productBatchEntity.getMealId());
        List<ProductBatchEntity> productBatchList = virtualFieldsService.getUserProductBatches(userDetails);

        if (productBatchList.contains(productBatchEntity)) {
            return ProductBatchMapper.mapToProductBatchDTO(productBatchEntity, productName, mealName);
        } else {
            throw new NoSuchElementException("The product batch you are looking for, does not belong to the user");
        }
    }

    @Transactional
    public void addProductBatch(ProductBatchSaveDTO product) {
        ProductBatchEntity productBatchEntity = ProductBatchMapper.mapToProductBatchSaveDTO(product);

        if (!productBatchEntity.getName().isEmpty() && productBatchEntity.getAmountInGrams() != null && productBatchEntity.getAmountInGrams() > 0) {
            BigDecimal productBatchCost = calculateProductBatchCost(productBatchEntity);

            if (productBatchEntity.getMealId() == 0 || productBatchEntity.getMealId() == null) {
                productBatchEntity.setMealId(null);
            } else {
                Integer mealId = productBatchEntity.getMealId();
                mealService.updateMealCost(mealId, productBatchCost);
            }

            productBatchEntity.setCost(productBatchCost);
            productBatchRepository.save(productBatchEntity);
        } else {
            throw new IllegalArgumentException("Parameters cannot be empty or less than zero");
        }
    }

    public void deleteProductBatch(Integer id, UserDetailsImpl userDetails) {
        ProductBatchEntity productBatchEntity = getProductBatchEntity(id);
        List<ProductBatchEntity> productBatchList = virtualFieldsService.getUserProductBatches(userDetails);

        if (productBatchList.contains(productBatchEntity)) {
            productBatchRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("The product batch you are looking for, does not belong to the user");
        }
    }

    private ProductBatchEntity getProductBatchEntity(Integer id) {
        return productBatchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cannot find any product batch from given id"));
    }

    private BigDecimal calculateProductBatchCost(ProductBatchEntity productBatchEntity) {
        if (productBatchEntity.getAmountInGrams() > 0) {
            BigDecimal productBatchAmountInGrams = BigDecimal.valueOf(productBatchEntity.getAmountInGrams());
            Double amountInGrams = productService.getProductAmountInGrams(productBatchEntity.getProductId());
            BigDecimal productAmountInGrams = BigDecimal.valueOf(amountInGrams);
            BigDecimal productPrice = productService.getProductPrice(productBatchEntity.getProductId());

            return productPrice.multiply(productBatchAmountInGrams).divide(productAmountInGrams, RoundingMode.HALF_UP);
        } else {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

}
