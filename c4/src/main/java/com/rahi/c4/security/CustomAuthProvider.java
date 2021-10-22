package com.rahi.c4.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author Amimul Ehsan
 * @Created at 10/22/21
 * @Project spring-security-c1
 */

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthProvider( UserDetailsService userDetailsService, PasswordEncoder passwordEncoder ) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        //Implement auth logic here
        // if request is authenticated,  return from here
        // If not authenticated, you should throw AuthException
        // The auth is not supported by this auth provider ->
        // return null(This tells the auth manager for look for another auth provider)

        String userName = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        var u = userDetailsService.loadUserByUsername(userName);

        if (u != null) {
            if (passwordEncoder.matches(password, u.getPassword())) {
                return new UsernamePasswordAuthenticationToken(userName, password, u.getAuthorities());
            }
        }

        throw new BadCredentialsException("Error!");
    }

    @Override
    public boolean supports( Class<?> authentication ) { //Type of the auth
        //This checks before calling authenticate() that this provider supports this type of auth or not
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
