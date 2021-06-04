package com.paw.mealcostingcalculator.dtos.saveDTOS;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealPlanSaveDTO {
    @DateTimeFormat (pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
}
