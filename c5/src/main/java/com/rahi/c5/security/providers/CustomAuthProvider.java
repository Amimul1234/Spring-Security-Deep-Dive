package com.rahi.c5.security.providers;

import com.rahi.c5.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Author Amimul Ehsan
 * @Created at 10/23/21
 * @Project spring-security-c1
 */

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Value("${key}")
    private String key;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        String requestKey = authentication.getName();

        if (requestKey.equals(key)) {
            return new CustomAuthentication(null, null, null);
        } else {
            throw new BadCredentialsException("BOO!");
        }
    }

    @Override
    public boolean supports( Class<?> authentication ) {
        return CustomAuthentication.class.equals(authentication);
    }
}
