package com.rahi.springsecurityc3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * @Author Amimul Ehsan
 * @Created at 10/22/21
 * @Project spring-security-c1
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JdbcUserDetailsManager userDetailsService() {
        return new JdbcUserDetailsManager(dataSource());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DataSource dataSource() {

        var driverManagerDataSource =
                new DriverManagerDataSource();

        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_security");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Rahi-8000");

        return driverManagerDataSource;
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.httpBasic();
        http.csrf().disable();

        http.authorizeRequests()
                .mvcMatchers("/user")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
