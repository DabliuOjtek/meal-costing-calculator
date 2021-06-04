package com.paw.mealcostingcalculator.repository;

import com.paw.mealcostingcalculator.model.ProductBatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBatchRepository extends JpaRepository <ProductBatchEntity,Integer> {
    List<ProductBatchEntity> findAllByMealIdIsNull();
}
