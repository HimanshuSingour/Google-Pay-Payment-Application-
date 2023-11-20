package com.pay.v1.server.v7.Google.Pay.Application.dtos;

import com.pay.v1.server.v7.Google.Pay.Application.validations.NumericValueAnnotation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.pay.v1.server.v7.Google.Pay.Application.constant.FieldsConstants.MSG_F_NAME_LENGTH_REQUIRED;
import static com.pay.v1.server.v7.Google.Pay.Application.constant.FieldsConstants.MSG_L_NAME_LENGTH_REQUIRED;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {


    @Size(min = 4, max = 15, message = MSG_F_NAME_LENGTH_REQUIRED)
    private String firstName;

    @Size(min = 4, max = 9, message = MSG_L_NAME_LENGTH_REQUIRED)
    private String lastName;

    private String city;
    private String country;
    private String password;

    @NumericValueAnnotation(message = "This field should have only numeric values")
    private String age;
    private String email;
    private String phoneNumber;

    private String address;
}
