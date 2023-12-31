package com.pay.v1.server.v7.Google.Pay.Application.security.customs;

import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import com.pay.v1.server.v7.Google.Pay.Application.exceptions.DetailsNotFoundExceptionSteps;
import com.pay.v1.server.v7.Google.Pay.Application.repository.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.pay.v1.server.v7.Google.Pay.Application.constant.UserConstants.DETAIL_NOT_FOUND;

@Service
public class CustomsUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserInformation userInformation = userRepositories.findByFirstName(name);
        if (userInformation == null) {

            throw new DetailsNotFoundExceptionSteps(DETAIL_NOT_FOUND);
        }
        return new CustomsUserDetails(userInformation);

    }
}
