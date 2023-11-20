package com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail;

import com.pay.v1.server.v7.Google.Pay.Application.validations.EmailValueAnnotation;
import com.pay.v1.server.v7.Google.Pay.Application.validations.NumericValueAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.pay.v1.server.v7.Google.Pay.Application.constant.FieldsConstants.MSG_EMAIL_FORMATE_REQUIRED;
import static com.pay.v1.server.v7.Google.Pay.Application.constant.FieldsConstants.MSG_NUMERIC_VALUE_REQUIRED;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDetailRequest {

    private String email;

    @NumericValueAnnotation(message = MSG_NUMERIC_VALUE_REQUIRED)
    private String phoneNumber;
}
