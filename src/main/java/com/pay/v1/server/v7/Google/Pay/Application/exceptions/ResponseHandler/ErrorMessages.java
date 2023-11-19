package com.pay.v1.server.v7.Google.Pay.Application.exceptions.ResponseHandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessages {

    private String messages;
    private String status;
}
