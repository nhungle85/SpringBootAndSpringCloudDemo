package com.nle.microservices.authentication.springsecurityjwt.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nle.microservices.authentication.springsecurityjwt.dto.CredentialDto;
import com.nle.microservices.authentication.springsecurityjwt.dto.UserProfileDto;
import com.nle.microservices.authentication.springsecurityjwt.model.UserProfile;
import com.nle.microservices.authentication.springsecurityjwt.service.UserProfileService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UserAuthenticationProvider {
    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expired-duration}")
    private int expiredDuration;

    private UserProfileService userProfileService;

    @PostConstruct
    protected void init() {
        //This is to avoid row secret key in the JVM
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + expiredDuration);

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withIssuer(username)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
    }

    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decoded = verifier.verify(token);

        //Find user by login username
        log.info("##verify token with login user: ", decoded.getIssuer());
        UserProfileDto user = UserProfileDto.fromEntity(userProfileService.findByUserName(decoded.getIssuer()));

        return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
    }

    public Authentication validateCredentials(CredentialDto credentialDto) {
        UserProfile user = userProfileService.authenticate(credentialDto);
        return new UsernamePasswordAuthenticationToken(UserProfileDto.fromEntity(user), null, Collections.emptyList());
    }
}
