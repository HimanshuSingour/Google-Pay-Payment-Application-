package com.pay.v1.server.v7.Google.Pay.Application.controller;

import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationResponse;
import com.pay.v1.server.v7.Google.Pay.Application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server/v4")
public class RegistrationController {

    @Autowired
    private UserService userService;


    @PostMapping("/register-user")
    ResponseEntity<UserRegistrationResponse> userRegistration(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest){
        UserRegistrationResponse userRegistrationResponse = userService.userRegistration(userRegistrationRequest);
        return new ResponseEntity<UserRegistrationResponse>(userRegistrationResponse , HttpStatus.CREATED);
    }
}
