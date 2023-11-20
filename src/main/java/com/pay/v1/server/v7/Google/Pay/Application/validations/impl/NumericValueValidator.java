package com.pay.v1.server.v7.Google.Pay.Application.validations.impl;

import com.pay.v1.server.v7.Google.Pay.Application.validations.NumericValueAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumericValueValidator implements ConstraintValidator<NumericValueAnnotation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[0-9]+");
    }
}
