package com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDetailResponse {

    private String lastName;
    private String firstName; // this is required for login
    private String password; // this is required for login;
    private String message;
    private String status;
}
