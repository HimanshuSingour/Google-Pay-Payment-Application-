package com.pay.v1.server.v7.Google.Pay.Application.validations;

import com.pay.v1.server.v7.Google.Pay.Application.validations.impl.EmailValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = EmailValueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValueAnnotation {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
