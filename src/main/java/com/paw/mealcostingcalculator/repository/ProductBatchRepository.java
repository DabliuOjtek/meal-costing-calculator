package com.paw.mealcostingcalculator.repository;

import com.paw.mealcostingcalculator.model.ProductBatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBatchRepository extends JpaRepository <ProductBatchEntity,Integer> {
}
