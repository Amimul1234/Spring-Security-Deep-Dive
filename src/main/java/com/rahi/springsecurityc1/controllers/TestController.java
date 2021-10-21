package com.rahi.springsecurityc1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Amimul Ehsan
 * @Created at 10/21/21
 * @Project spring-security-c1
 */

@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        return "Test";
    }
}
