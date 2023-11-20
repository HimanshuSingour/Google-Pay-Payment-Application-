package com.pay.v1.server.v7.Google.Pay.Application.validations;

import com.pay.v1.server.v7.Google.Pay.Application.validations.impl.NumericValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = NumericValueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NumericValueAnnotation {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
