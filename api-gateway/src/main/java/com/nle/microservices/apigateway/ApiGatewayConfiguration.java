package com.nle.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    //Define custom bean
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p-> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**") //if request start with currency-conversion
                        .uri("lb://currency-conversion"))              //redirect to naming service -> load balancing the instance with name currency-conversion

                .route(p -> p.path("/exchange-by-new/**")    //add custom path
                        .filters(f -> f.rewritePath(
                                "/exchange-by-new/(?<segment>.*)",
                                "/currency-conversion/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
