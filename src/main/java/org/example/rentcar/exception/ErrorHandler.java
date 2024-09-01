package org.example.rentcar.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<String> handle(NotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(BalanceException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<String> handle(BalanceException exception){
        return new ResponseEntity<>(exception.getMessage(),METHOD_NOT_ALLOWED);
    }


}
