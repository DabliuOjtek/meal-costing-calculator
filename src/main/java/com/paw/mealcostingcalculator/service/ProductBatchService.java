package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.dto.ProductBatchDTO;
import com.paw.mealcostingcalculator.model.ProductBatchEntity;
import com.paw.mealcostingcalculator.repository.ProductBatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductBatchService {

    private final ProductBatchRepository productBatchRepository;

    public List<ProductBatchDTO> getAllProductBatches(){
        return null;
    }

    public ProductBatchDTO getSingleProductBatch(Integer id){
        return null;
    }

    public ProductBatchEntity addProductBatch(ProductBatchEntity productBatch) {
        return productBatchRepository.save(productBatch);
    }

    public void deleteProductBatch(Integer id) {
        productBatchRepository.deleteById(id);
    }
}
