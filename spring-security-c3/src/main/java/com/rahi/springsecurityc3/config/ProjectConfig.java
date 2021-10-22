package com.rahi.springsecurityc3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * @Author Amimul Ehsan
 * @Created at 10/22/21
 * @Project spring-security-c1
 */

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new JdbcUserDetailsManager(dataSource());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
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
}
