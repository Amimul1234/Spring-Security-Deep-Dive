package com.rahi.c4.config;

import com.rahi.c4.security.CustomAuthProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Author Amimul Ehsan
 * @Created at 10/22/21
 * @Project spring-security-c1
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthProvider customAuthProvider;

    public ProjectConfig( CustomAuthProvider customAuthProvider ) {
        this.customAuthProvider = customAuthProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {

        var uds = new InMemoryUserDetailsManager();
        var u = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        uds.createUser(u);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.authenticationProvider(customAuthProvider);
    }
}
