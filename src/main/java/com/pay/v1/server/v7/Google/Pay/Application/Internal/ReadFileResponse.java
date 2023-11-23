package com.pay.v1.server.v7.Google.Pay.Application.Internal;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class ReadFileResponse {

    public ReadFileResponse readJsonFile() throws IOException {

        String JSON_FILE = "/Users/himanshu/Desktop/Google-Pay-Payment-Application-/src/main/resources/sample.json";
        File file = ResourceUtils.getFile(JSON_FILE);
        ObjectMapper objectMapper = new ObjectMapper();
        ReadFileResponse readFileResponse = objectMapper.readValue(file, ReadFileResponse.class);

        System.out.println(readFileResponse);
        return null;
    }
}
