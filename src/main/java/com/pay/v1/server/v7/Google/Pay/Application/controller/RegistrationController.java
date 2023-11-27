package com.pay.v1.server.v7.Google.Pay.Application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.JsonFile.ResponseForJson;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailResponse;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationResponse;
import com.pay.v1.server.v7.Google.Pay.Application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server/v4")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register-user")
    ResponseEntity<UserRegistrationResponse> userRegistration(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) {
        UserRegistrationResponse userRegistrationResponse = userService.userRegistration(userRegistrationRequest);
        return new ResponseEntity<UserRegistrationResponse>(userRegistrationResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get-login-info")
    ResponseEntity<LoginDetailResponse> getLoginInfo(@RequestBody @Valid LoginDetailRequest loginDetailRequest) {
        LoginDetailResponse loginDetailResponse = userService.getYourLoginDetails(loginDetailRequest);
        return new ResponseEntity<LoginDetailResponse>(loginDetailResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get-json-data/{userId}")
    ResponseEntity<List<ResponseForJson>> getLoginInfo(@PathVariable String userId) throws JsonProcessingException {
        List<ResponseForJson> loginDetailResponse = userService.readDatFromJson(userId);
        return new ResponseEntity<List<ResponseForJson>>(loginDetailResponse, HttpStatus.CREATED);
    }
}
