package com.pay.v1.server.v7.Google.Pay.Application.repository;

import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<UserInformation, String> {
    Optional<UserInformation> existByEmail(String email);

    Optional<UserInformation> existByPhoneNumber(String phoneNumber);
}
