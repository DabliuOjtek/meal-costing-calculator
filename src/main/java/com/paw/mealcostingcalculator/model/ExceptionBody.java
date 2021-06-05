package com.paw.mealcostingcalculator.model;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class ExceptionBody {

    private final Integer status;
    private final String message;
    private final List<String> errors;

    public ExceptionBody(Integer status, String message, String errorMessage){
        this.status = status;
        this.message = message;
        this.errors = Collections.singletonList(errorMessage);
    }

}
