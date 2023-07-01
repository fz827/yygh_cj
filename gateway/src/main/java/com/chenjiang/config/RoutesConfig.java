package com.chenjiang.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("consumer-hospital-cj-route", r -> r.path("/department/**","/doctor/**","/illness/**")
                        .uri("lb://consumer-hospital-cj"))
                .route("consumer-order-cj-route", r -> r.path("/orderInfo/**")
                        .uri("lb://consumer-order-cj"))
                .route("consumer-user-cj-route", r -> r.path("/doLogin/**","/doRegister/**")
                        .uri("lb://consumer-user-cj"))
                .build();
    }
}
