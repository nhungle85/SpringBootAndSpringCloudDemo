package com.nle.microservices.authentication.springsecurityjwt.service;

import com.nle.microservices.authentication.springsecurityjwt.model.UserProfile;
import com.nle.microservices.authentication.springsecurityjwt.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class UserProfileService {
    private UserProfileRepository repository;

    public List<UserProfile> findAll() {
        return repository.findAll();
    }
    public UserProfile findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public UserProfile findById(long id) {
        return repository.findById(id).orElse(new UserProfile());
    }
}
