package com.pay.v1.server.v7.Google.Pay.Application.service;

import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationResponse;

public interface UserService {

    UserRegistrationResponse userRegistration(UserRegistrationRequest userRegistrationRequest);


}
