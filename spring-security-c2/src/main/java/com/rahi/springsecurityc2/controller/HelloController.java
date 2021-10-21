package com.rahi.springsecurityc2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Amimul Ehsan
 * @Created at 10/21/21
 * @Project spring-security-c1
 */


@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "Hello!";
    }
}
