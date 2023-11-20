package com.pay.v1.server.v7.Google.Pay.Application.exceptions.handler;

import com.pay.v1.server.v7.Google.Pay.Application.exceptions.DuplicatesExceptionSteps;
import com.pay.v1.server.v7.Google.Pay.Application.exceptions.ResponseHandler.ErrorMessages;
import com.pay.v1.server.v7.Google.Pay.Application.exceptions.UserServiceExceptionSteps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import java.util.Map;



@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserServiceExceptionSteps.class)
    public ResponseEntity<ErrorMessages> userServiceErrorHandler(UserServiceExceptionSteps ex) {

        ErrorMessages errorMessages = ErrorMessages.builder()
                .messages(ex.getMessage())
                .status("REJECTED")
                .build();

        return new ResponseEntity<ErrorMessages>(errorMessages, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DuplicatesExceptionSteps.class)
    public ResponseEntity<ErrorMessages> userDuplicate(DuplicatesExceptionSteps ex) {

        ErrorMessages errorMessages = ErrorMessages.builder()
                .messages(ex.getMessage())
                .status("DUPLICATE")
                .build();

        return new ResponseEntity<ErrorMessages>(errorMessages, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> userDuplicate(MethodArgumentNotValidException ex) {

        Map<String, String> errorMessages = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errorMessages.put(fieldName, message);
        });

        return new ResponseEntity<>(errorMessages, HttpStatus.NOT_ACCEPTABLE);
    }

}
