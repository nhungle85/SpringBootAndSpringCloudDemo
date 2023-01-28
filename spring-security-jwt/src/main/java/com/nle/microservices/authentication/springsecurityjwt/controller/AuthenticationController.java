package com.nle.microservices.authentication.springsecurityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate-service")
public class AuthenticationController {
    @GetMapping("/sayHi/{name}")
    public String sayHi(@PathVariable String name) {
        return "Hi " + name;
    }
}
