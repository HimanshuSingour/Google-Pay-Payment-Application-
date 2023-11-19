package com.pay.v1.server.v7.Google.Pay.Application.serviceImpl;

import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegistrationResponse;
import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import com.pay.v1.server.v7.Google.Pay.Application.exceptions.UserServiceExceptionSteps;
import com.pay.v1.server.v7.Google.Pay.Application.repository.UserRepositories;
import com.pay.v1.server.v7.Google.Pay.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.pay.v1.server.v7.Google.Pay.Application.constant.UserConstants.*;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepositories userRepositories;


    @Override
    public UserRegistrationResponse userRegistration(UserRegistrationRequest userRegistrationRequest) {

        List<String> requiredFields = Arrays.asList(userRegistrationRequest.getAddress(), userRegistrationRequest.getAge(),
                userRegistrationRequest.getCity(), userRegistrationRequest.getEmail(), userRegistrationRequest.getLastName(),
                userRegistrationRequest.getFirstName(), userRegistrationRequest.getCountry(), userRegistrationRequest.getPhoneNumber()
        );

        if (requiredFields.stream().anyMatch(String::isBlank)) {
            throw new UserServiceExceptionSteps(ALL_FIELD_REQUIRED);
        }

        UserInformation userInformation = UserInformation.builder()
                .userId(UUID.randomUUID().toString())
                .age(userRegistrationRequest.getAge())
                .address(userRegistrationRequest.getAddress())
                .city(userRegistrationRequest.getCity())
                .email(userRegistrationRequest.getEmail())
                .firstName(userRegistrationRequest.getFirstName())
                .lastName(userRegistrationRequest.getLastName())
                .country(userRegistrationRequest.getCountry())
                .city(userRegistrationRequest.getCity())
                .phoneNumber(userRegistrationRequest.getPhoneNumber())
                .build();

        userRepositories.save(userInformation);

        return UserRegistrationResponse.builder()
                .name(userInformation.getFirstName() + " " + userInformation.getLastName())
                .address(userInformation.getAddress())
                .message(SUCCESSFULLY_REGISTERED)
                .userId(userInformation.getUserId())
                .status(SUCCESS_ONE)
                .city(userInformation.getCity())
                .email(userInformation.getEmail())
                .country(userInformation.getCountry())
                .phoneNumber(userInformation.getPhoneNumber())
                .build();

    }
}
