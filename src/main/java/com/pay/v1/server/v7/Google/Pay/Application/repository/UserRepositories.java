package com.pay.v1.server.v7.Google.Pay.Application.repository;

import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<UserInformation, String> {

    @Query("SELECT u FROM UserInformation u WHERE u.email =:email")
    List<UserInformation> existByEmail(String email);

    @Query("SELECT u FROM UserInformation u WHERE u.phoneNumber =:phoneNumber")
    List<UserInformation> existByPhoneNumber(String phoneNumber);

    @Query("SELECT u FROM UserInformation u WHERE u.firstName =:firstName")
    UserInformation findByFirstName(String firstName);

    Optional<UserInformation> findByPhoneNumber(String phoneNumber);
}
