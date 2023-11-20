package com.pay.v1.server.v7.Google.Pay.Application.validations.impl;

import com.pay.v1.server.v7.Google.Pay.Application.validations.EmailValueAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValueValidator implements ConstraintValidator<EmailValueAnnotation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return regex.matches(value);
    }
}
