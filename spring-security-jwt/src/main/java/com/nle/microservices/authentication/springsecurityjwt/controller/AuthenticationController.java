package com.nle.microservices.authentication.springsecurityjwt.controller;

import com.nle.microservices.authentication.springsecurityjwt.config.UserAuthenticationProvider;
import com.nle.microservices.authentication.springsecurityjwt.dto.UserProfileDto;
import com.nle.microservices.authentication.springsecurityjwt.service.UserProfileService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate-service")
@Data
@AllArgsConstructor
public class AuthenticationController {
    private UserProfileService userProfileService;
    private UserAuthenticationProvider userAuthenticationProvider;

    @GetMapping("/sayHi")
    public String sayHi(@PathVariable String name) {
        return "Hi!";
    }

    @PostMapping("/signIn")
    public ResponseEntity<UserProfileDto> signIn(@AuthenticationPrincipal UserProfileDto user) {
        user.setToken(userAuthenticationProvider.createToken(user.getUserName()));
        return ResponseEntity.ok(user);
    }
}
