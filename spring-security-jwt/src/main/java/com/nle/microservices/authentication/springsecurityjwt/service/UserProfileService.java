package com.nle.microservices.authentication.springsecurityjwt.service;

import com.nle.microservices.authentication.springsecurityjwt.dto.CredentialDto;
import com.nle.microservices.authentication.springsecurityjwt.model.UserProfile;
import com.nle.microservices.authentication.springsecurityjwt.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class UserProfileService {
    private UserProfileRepository repository;
    private PasswordEncoder passwordEncoder;

    public List<UserProfile> findAll() {
        return repository.findAll();
    }
    public UserProfile findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public UserProfile findById(long id) {
        return repository.findById(id).orElse(new UserProfile());
    }

    public UserProfile authenticate(CredentialDto credentialDto) {
        UserProfile userInDB = findByUserName(credentialDto.getUserName());

        String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap(userInDB.getPassword()));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialDto.getPassword()), encodedMasterPassword)) {
            return userInDB;
        }
        throw new RuntimeException("Invalid password");
    }
}
