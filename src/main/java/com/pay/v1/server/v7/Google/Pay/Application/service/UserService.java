package com.pay.v1.server.v7.Google.Pay.Application.service;

import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailResponse;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationResponse;

public interface UserService {

    UserRegistrationResponse userRegistration(UserRegistrationRequest userRegistrationRequest);

    LoginDetailResponse getYourLoginDetails(LoginDetailRequest loginDetailRequest);

}
