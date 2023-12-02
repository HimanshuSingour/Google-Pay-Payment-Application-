package com.pay.v1.server.v7.Google.Pay.Application.controller;


import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import com.pay.v1.server.v7.Google.Pay.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spec/v1")
public class SpecificationController {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    ResponseEntity<List<UserInformation>> specifc(@PathVariable String firstname){
        List<UserInformation> specifications = userService.searchWithCriteria(firstname);
        return new ResponseEntity<List<UserInformation>>(specifications , HttpStatus.CREATED);
    }
}
