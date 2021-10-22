package com.rahi.springsecurityc3.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author Amimul Ehsan
 * @Created at 10/22/21
 * @Project spring-security-c1
 */


public class User implements UserDetails {

    private String username;
    private String password;
    private final List<GrantedAuthority> grantedAuthorities =
            new ArrayList<>();

    public String getUserName() {
        return username;
    }

    public void setUserName( String userName ) {
        this.username = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
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

    public void setPassword( String password ) {
        this.password = password;
    }
}
