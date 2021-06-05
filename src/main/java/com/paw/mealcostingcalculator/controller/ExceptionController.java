package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.model.ExceptionBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ExceptionBody> handleNoSuchElementException(NoSuchElementException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionBody body = new ExceptionBody(status.value(), status.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.valueOf(body.getStatus()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ExceptionBody> handleIllegalArgumentException(IllegalArgumentException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionBody body = new ExceptionBody(status.value(), status.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.valueOf(body.getStatus()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity<ExceptionBody> handleUserNotFound(UsernameNotFoundException e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ExceptionBody body = new ExceptionBody(status.value(), status.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.valueOf(body.getStatus()));
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<ExceptionBody> handleAuthenticationException(AuthenticationException e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ExceptionBody body = new ExceptionBody(status.value(), status.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.valueOf(body.getStatus()));
    }


}
