package com.pay.v1.server.v7.Google.Pay.Application.constant;

import lombok.Data;

@Data
public class UserConstants {

    public static final String ALL_FIELD_REQUIRED = "Completion of all fields is mandatory for submission, thank you";
    public static final String SUCCESSFULLY_REGISTERED = "Your account have been created successfully";

    public static final String DUPLICATE_EMAIL_EXIST = "This email address is already registered.";
    public static final String DUPLICATE_PHONE_NUMBER_EXIST = "This phone number is already in use.";
    public static final String SUCCESS_ONE = "SUCCESS";

    public static final String DETAIL_NOT_FOUND = "You haven't registered your account yet. there is no account found with this details";

    public static final String USER_LOGIN_INFO = "You can log in using your first name as username and the provided password.";



}
