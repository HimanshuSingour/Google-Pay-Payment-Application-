package com.pay.v1.server.v7.Google.Pay.Application.constant;

import lombok.Data;

@Data
public class FieldsConstants {

    public static final String MSG_F_NAME_LENGTH_REQUIRED = "FirstName should be between 4 to 15 characters";
    public static final String MSG_L_NAME_LENGTH_REQUIRED = "LastName should be between 4 to 9 characters";

    public static final String MSG_NUMERIC_VALUE_REQUIRED = "Should be only Numeric Value";
    public static final String MSG_EMAIL_FORMATE_REQUIRED = "@gamil.com is required at the end";
}
