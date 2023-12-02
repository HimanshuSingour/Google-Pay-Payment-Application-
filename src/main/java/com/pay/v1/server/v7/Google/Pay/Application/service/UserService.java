package com.pay.v1.server.v7.Google.Pay.Application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.JsonFile.ResponseForJson;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailResponse;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationResponse;
import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;

import java.util.List;

public interface UserService {

    // Testing

    List<ResponseForJson> readDatFromJson(String userId) throws JsonProcessingException;


    // TODO: Users Process

    UserRegistrationResponse userRegistration(UserRegistrationRequest userRegistrationRequest);

    LoginDetailResponse getYourLoginDetails(LoginDetailRequest loginDetailRequest);

    List<UserInformation> searchWithCriteria(String firstname);


}
