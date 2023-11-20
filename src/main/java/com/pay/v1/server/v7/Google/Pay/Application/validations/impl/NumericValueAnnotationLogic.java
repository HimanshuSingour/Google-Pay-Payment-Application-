package com.pay.v1.server.v7.Google.Pay.Application.validations.impl;

import com.pay.v1.server.v7.Google.Pay.Application.validations.NumericValueAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class NumericValueAnnotationLogic implements ConstraintValidator<NumericValueAnnotation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[0-9]+");
    }
}
