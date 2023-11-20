package com.pay.v1.server.v7.Google.Pay.Application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "USER_INFO")
@Entity
@Component
public class UserInformation {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_FNAME")
    private String firstName;

    @Column(name = "USER_LNAME")
    private String lastName;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_AGE")
    private String age;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_CITY")
    private String city;

    @Column(name = "USER_COUNTRY")
    private String country;

    @Column(name = "USER_PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "USER_ADDRESS")
    private String address;

}
