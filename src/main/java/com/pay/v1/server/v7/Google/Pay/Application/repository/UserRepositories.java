package com.pay.v1.server.v7.Google.Pay.Application.repository;

import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<UserInformation, String> {

    @Query("SELECT u FROM UserInformation u WHERE u.email =:email")
    Optional<UserInformation> existByEmail(String email);

    @Query("SELECT u FROM UserInformation u WHERE u.phoneNumber =:phoneNumber")
    Optional<UserInformation> existByPhoneNumber(String phoneNumber);
}
