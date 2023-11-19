package com.pay.v1.server.v7.Google.Pay.Application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationResponse {

    private String userId;
    private String name;
    private String email;
    private String age;
    private String city;
    private String country;
    private String phoneNumber;
    private String address;
    private String status;
    private String message;
}
