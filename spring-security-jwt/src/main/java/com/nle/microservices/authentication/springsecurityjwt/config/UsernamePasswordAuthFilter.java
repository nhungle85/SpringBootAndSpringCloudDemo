package com.nle.microservices.authentication.springsecurityjwt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nle.microservices.authentication.springsecurityjwt.dto.CredentialDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Slf4j
public class UsernamePasswordAuthFilter extends OncePerRequestFilter {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final UserAuthenticationProvider userAuthenticationProvider;

    public UsernamePasswordAuthFilter(UserAuthenticationProvider provider) {
        this.userAuthenticationProvider = provider;
    }

    /**
     * Intercept the request before getting to the controller to validate the password
     * Return invalid password IF NOT MATCH
     * or else continue to controller signin and return token.
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("###UsernamePasswordAuthFilter: doFilterInternal");
        if ("/authenticate-service/signIn".equals(request.getServletPath())
                && HttpMethod.POST.matches(request.getMethod())) {
            CredentialDto credentialDto = MAPPER.readValue(request.getInputStream(), CredentialDto.class);
            log.info("### credential: " + credentialDto.getUserName());
            try{
                SecurityContextHolder.getContext().setAuthentication(userAuthenticationProvider.validateCredentials(credentialDto));

            } catch (RuntimeException e) {
                SecurityContextHolder.clearContext();
                throw e;
            }

            filterChain.doFilter(request, response);
        }
    }
}
