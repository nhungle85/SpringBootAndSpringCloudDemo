package com.nle.microservices.limitsservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.nle.microservices.limitsservice")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
}
