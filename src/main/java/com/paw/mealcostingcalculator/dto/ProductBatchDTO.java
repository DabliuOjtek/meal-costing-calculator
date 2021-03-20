package com.paw.mealcostingcalculator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class ProductBatchDTO{
        private Integer product_batch_id;
        private Double amount_in_grams;
        private BigDecimal cost;
        private ProductDTO product;
}
