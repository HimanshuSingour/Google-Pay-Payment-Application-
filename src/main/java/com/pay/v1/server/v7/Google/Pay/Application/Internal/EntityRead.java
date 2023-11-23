package com.pay.v1.server.v7.Google.Pay.Application.Internal;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityRead {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String age;

    private String password;

    private String city;

    private String country;

    private String phoneNumber;

    private String address;
}
