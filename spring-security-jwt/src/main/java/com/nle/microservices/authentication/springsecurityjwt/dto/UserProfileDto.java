package com.nle.microservices.authentication.springsecurityjwt.dto;

import com.nle.microservices.authentication.springsecurityjwt.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileDto {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String login;
    private String token;

    public static UserProfileDto fromEntity(UserProfile entity) {
        return UserProfileDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .userName(entity.getUserName())
                .build();
    }
}
