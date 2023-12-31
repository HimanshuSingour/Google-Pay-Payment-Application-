package com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister;

import com.pay.v1.server.v7.Google.Pay.Application.validations.EmailValueAnnotation;
import com.pay.v1.server.v7.Google.Pay.Application.validations.NumericValueAnnotation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.pay.v1.server.v7.Google.Pay.Application.constant.FieldsConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {


    @Size(min = 4, max = 15, message = MSG_F_NAME_LENGTH_REQUIRED)
    private String firstName;

    @Size(min = 4, max = 9, message = MSG_L_NAME_LENGTH_REQUIRED)
    private String lastName;

    @NumericValueAnnotation(message = MSG_NUMERIC_VALUE_REQUIRED)
    private String age;

    @NumericValueAnnotation(message = MSG_NUMERIC_VALUE_REQUIRED)
    private String phoneNumber;

    @EmailValueAnnotation(message = MSG_EMAIL_FORMATE_REQUIRED)
    private String email;
    private String city;
    private String country;
    private String password;
    private String address;
}
