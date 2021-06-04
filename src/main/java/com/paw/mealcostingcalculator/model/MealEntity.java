package com.paw.mealcostingcalculator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="meal")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mealId;
    private String name;
    private BigDecimal cost;
    private Integer mealPlanId;

    @OneToMany(mappedBy = "mealId", fetch = FetchType.LAZY)
    private List<ProductBatchEntity> products;
    
}
