package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.dto.ProductDTO;
import com.paw.mealcostingcalculator.mapper.ProductMapper;
import com.paw.mealcostingcalculator.model.ProductEntity;
import com.paw.mealcostingcalculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return ProductMapper.mapToProductDTOS(productRepository.findAll());
    }

    public ProductDTO getSingleProduct(Integer id){
        return ProductMapper.mapToProductDTO(productRepository.findById(id).orElseThrow());
    }

    public ProductEntity addProduct(ProductEntity product){
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
