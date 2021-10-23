package com.rahi.c5.security.filter;

import com.rahi.c5.security.authentication.CustomAuthentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author Amimul Ehsan
 * @Created at 10/23/21
 * @Project spring-security-c1
 */

@Component
public class CustomAuthFilter implements Filter {

    private final AuthenticationManager authenticationManager;

    public CustomAuthFilter( AuthenticationManager authenticationManager ) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse,
                          FilterChain filterChain ) throws IOException, ServletException {

        var http = (HttpServletRequest) servletRequest;
        String authHeader = http.getHeader("Authorization");

        var a = new CustomAuthentication(authHeader, null);
        Authentication authenticateResult = authenticationManager.authenticate(a);
        //This is the line where we get a fully authenticated object

        if (authenticateResult.isAuthenticated()) {
            //Filters need to place auth obj. to security context
            SecurityContextHolder.getContext().setAuthentication(authenticateResult);
            //Continue the responsibility
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
