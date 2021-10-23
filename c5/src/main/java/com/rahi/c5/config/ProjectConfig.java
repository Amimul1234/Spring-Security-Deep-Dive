package com.rahi.c5.config;

import com.rahi.c5.security.filter.CustomAuthFilter;
import com.rahi.c5.security.providers.CustomAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @Author Amimul Ehsan
 * @Created at 10/23/21
 * @Project spring-security-c1
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthFilter customAuthFilter;

    @Autowired
    private CustomAuthProvider customAuthProvider;

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.authenticationProvider(customAuthProvider);
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http.addFilterAt(customAuthFilter, BasicAuthenticationFilter.class);

        http.authorizeRequests()
                .anyRequest()
                .permitAll();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
