package com.paw.mealcostingcalculator.dtos.detailsDTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class MealDetailsDTO {
    private Integer mealId;
    private String name;
    private BigDecimal cost;
    private Integer mealPlanId;
    private LocalDate mealPlanDate;
    private List<ProductBatchShortDTO> productBatches;
}
