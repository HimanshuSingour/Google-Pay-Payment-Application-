package com.pay.v1.server.v7.Google.Pay.Application.security.customs;

import com.pay.v1.server.v7.Google.Pay.Application.entity.UserInformation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomsUserDetails implements UserDetails {

    private UserInformation information;

    public CustomsUserDetails(UserInformation information) {
        super();
        this.information = information;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return information.getPassword();
    }

    @Override
    public String getUsername() {
        return information.getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
