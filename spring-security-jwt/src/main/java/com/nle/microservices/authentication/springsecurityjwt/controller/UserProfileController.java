package com.nle.microservices.authentication.springsecurityjwt.controller;

import com.nle.microservices.authentication.springsecurityjwt.dto.UserProfileDto;
import com.nle.microservices.authentication.springsecurityjwt.service.UserProfileService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user-profile")
@Data
@AllArgsConstructor
public class UserProfileController {

    private UserProfileService service;

    @GetMapping("/findAll")
    public List<UserProfileDto> findAll() {
        return service.findAll().stream().map(UserProfileDto::fromEntity)
                                            .collect(Collectors.toList());
    }

    @GetMapping("/findByUserName/{userName}")
    public UserProfileDto findByUserName(@PathVariable(required = true) String userName) {
        return UserProfileDto.fromEntity(service.findByUserName(userName));
    }
}
