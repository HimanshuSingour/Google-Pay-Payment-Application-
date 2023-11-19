package com.pay.v1.server.v7.Google.Pay.Application.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String city;
    private String country;
    private String phoneNumber;
    private String address;
}
