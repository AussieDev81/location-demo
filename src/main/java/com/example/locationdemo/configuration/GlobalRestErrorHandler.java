package com.example.locationdemo.configuration;

import com.example.locationdemo.exception.CustomException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalRestErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex){
        return ResponseEntity.badRequest().body("Constraint Violation Exception: "+ ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex){
        return ResponseEntity.badRequest().body("Entity Not Found Exception: "+ ex.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        return ResponseEntity.badRequest().body("Http Request Method Not Supported Exception: "+ ex.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex, HttpServletRequest request){
        return ResponseEntity.badRequest().body(String.format("Error: %s by the endpoint \"%s\"", ex.getMessage(), request.getRequestURI()));
        //Error: This exception was thrown intentionally by the endpoint "/throw"
    }
}
