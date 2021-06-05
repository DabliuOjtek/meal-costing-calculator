package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.dtos.ProductDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.ProductSaveDTO;
import com.paw.mealcostingcalculator.mapper.ProductMapper;
import com.paw.mealcostingcalculator.model.ProductEntity;
import com.paw.mealcostingcalculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return ProductMapper.mapToProductDTOS(productRepository.findAll());
    }

    public ProductDTO getSingleProduct(Integer id) {
        return ProductMapper.mapToProductDTO(productRepository.findById(id).orElseThrow());
    }

    @Transactional
    public void addProduct(ProductSaveDTO product) {
        ProductEntity productEntity = ProductMapper.mapToProductSaveDTO(product);

        if (!productEntity.getName().isEmpty() && productEntity.getAmountInGrams() != null &&
                productEntity.getAmountInGrams() > 0 &&
                productEntity.getPrice() != null &&
                productEntity.getAmountInGrams() > 0) {
            productRepository.save(productEntity);
        } else {
            throw new IllegalArgumentException("Parameters cannot be empty or less than zero");
        }
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public String getProductName(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return productEntity.getName();
    }

    public BigDecimal getProductPrice(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return productEntity.getPrice();
    }

    public Double getProductAmountInGrams(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return productEntity.getAmountInGrams();
    }
}
