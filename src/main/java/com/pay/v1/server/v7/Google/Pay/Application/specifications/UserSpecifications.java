package com.pay.v1.server.v7.Google.Pay.Application.specifications;

import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class UserSpecifications {

    public static Specification<UserInformation> withName(String firstName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("firstName"), firstName);
    }

}

