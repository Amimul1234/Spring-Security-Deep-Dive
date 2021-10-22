package com.rahi.springsecurityc3.controller;

import com.rahi.springsecurityc3.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Amimul Ehsan
 * @Created at 10/21/21
 * @Project spring-security-c1
 */

@RestController
public class HelloController {

    private final JdbcUserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public HelloController( JdbcUserDetailsManager userDetailsManager,
                            PasswordEncoder passwordEncoder ) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello!";
    }

    @PostMapping("user")
    public void addUser( @RequestBody User user ) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsManager.createUser(user);
    }
}
