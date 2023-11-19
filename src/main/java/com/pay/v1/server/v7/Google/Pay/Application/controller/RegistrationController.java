package com.pay.v1.server.v7.Google.Pay.Application.controller;

import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationResponse;
import com.pay.v1.server.v7.Google.Pay.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pay/v4/")
public class RegistrationController {

    @Autowired
    private UserService userService;


    @PostMapping("/account/register")
    ResponseEntity<UserRegistrationResponse> userRegistration(@RequestBody  UserRegistrationRequest userRegistrationRequest){
        UserRegistrationResponse userRegistrationResponse = userService.userRegistration(userRegistrationRequest);
        return new ResponseEntity<UserRegistrationResponse>(userRegistrationResponse , HttpStatus.CREATED);
    }
}