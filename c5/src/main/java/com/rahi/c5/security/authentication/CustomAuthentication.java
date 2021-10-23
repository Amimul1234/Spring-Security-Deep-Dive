package com.rahi.c5.security.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author Amimul Ehsan
 * @Created at 10/23/21
 * @Project spring-security-c1
 */


public class CustomAuthentication
        extends UsernamePasswordAuthenticationToken {

    public CustomAuthentication( Object principal, Object credentials ) {
        super(principal, credentials);
    }

    public CustomAuthentication( Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities ) {
        super(principal, credentials, authorities);
    }

}
