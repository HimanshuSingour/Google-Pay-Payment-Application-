package com.pay.v1.server.v7.Google.Pay.Application.serviceImpl;

import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.LoginDetail.LoginDetailResponse;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationRequest;
import com.pay.v1.server.v7.Google.Pay.Application.dtos.UserRegister.UserRegistrationResponse;
import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import com.pay.v1.server.v7.Google.Pay.Application.exceptions.DetailsNotFoundExceptionSteps;
import com.pay.v1.server.v7.Google.Pay.Application.exceptions.DuplicatesOccursExceptionSteps;
import com.pay.v1.server.v7.Google.Pay.Application.exceptions.UserServiceExceptionSteps;
import com.pay.v1.server.v7.Google.Pay.Application.repository.UserRepositories;
import com.pay.v1.server.v7.Google.Pay.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.pay.v1.server.v7.Google.Pay.Application.constant.UserConstants.*;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepositories userRepositories;


    @Override
    public UserRegistrationResponse userRegistration(UserRegistrationRequest userRegistrationRequest) {

        List<String> requiredFields = Arrays.asList(userRegistrationRequest.getAddress(), userRegistrationRequest.getAge(),
                userRegistrationRequest.getCity(), userRegistrationRequest.getPassword(), userRegistrationRequest.getEmail(), userRegistrationRequest.getLastName(),
                userRegistrationRequest.getFirstName(), userRegistrationRequest.getCountry(), userRegistrationRequest.getPhoneNumber()
        );

        if (requiredFields.stream().anyMatch(String::isBlank)) {
            throw new UserServiceExceptionSteps(ALL_FIELD_REQUIRED);
        }

        List<UserInformation> existSameEmail = userRepositories.existByEmail(userRegistrationRequest.getEmail());
        List<UserInformation> existSamePhoneNumber = userRepositories.existByPhoneNumber(userRegistrationRequest.getPhoneNumber());
        {
            if (!existSameEmail.isEmpty()) {
                throw new DuplicatesOccursExceptionSteps(DUPLICATE_EMAIL_EXIST);
            } else if (!existSamePhoneNumber.isEmpty()) {
                throw new DuplicatesOccursExceptionSteps(DUPLICATE_PHONE_NUMBER_EXIST);
            }
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
                .password(userRegistrationRequest.getPassword())
                .phoneNumber(userRegistrationRequest.getPhoneNumber())
                .build();

        userRepositories.save(userInformation);

        return UserRegistrationResponse.builder()
                .name(userInformation.getFirstName() + " " + userInformation.getLastName())
                .address(userInformation.getAddress())
                .message(SUCCESSFULLY_REGISTERED)
                .userId(userInformation.getUserId())
                .status(SUCCESS_ONE)
                .age(userInformation.getAge())
                .city(userInformation.getCity())
                .email(userInformation.getEmail())
                .country(userInformation.getCountry())
                .phoneNumber(userInformation.getPhoneNumber())
                .build();

    }

    @Override
    public LoginDetailResponse getYourLoginDetails(LoginDetailRequest loginDetailRequest) {

        List<String> requiredFields = Arrays.asList(loginDetailRequest.getEmail(), loginDetailRequest.getPhoneNumber());
        if (requiredFields.stream().anyMatch(String::isBlank)) {
            throw new UserServiceExceptionSteps(ALL_FIELD_REQUIRED);
        }

        LoginDetailResponse detailRequest = null;
        Optional<UserInformation> information = userRepositories.findByPhoneNumber(loginDetailRequest.getPhoneNumber());
        if (information.isPresent()) {
            UserInformation getValue = information.get();

            detailRequest = LoginDetailResponse.builder()
                    .lastName(getValue.getLastName())
                    .password(getValue.getPassword())
                    .firstName(getValue.getFirstName())
                    .status("ACCEPTED")
                    .message(USER_LOGIN_INFO)
                    .build();
        } else {
            throw new DetailsNotFoundExceptionSteps(DETAIL_NOT_FOUND);
        }

        return detailRequest;
    }
}
