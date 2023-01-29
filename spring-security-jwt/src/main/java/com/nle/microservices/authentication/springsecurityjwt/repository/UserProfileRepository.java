package com.nle.microservices.authentication.springsecurityjwt.repository;

import com.nle.microservices.authentication.springsecurityjwt.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    public UserProfile findByUserName(String userName);
}
