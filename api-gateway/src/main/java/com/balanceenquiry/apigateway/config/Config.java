package com.balanceenquiry.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.balanceenquiry.apigateway.filter.AuthenticationGatewayFilterFactory;

@Configuration
public class Config {
	
    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder rlb, AuthenticationGatewayFilterFactory
            authorizationHeaderFilter) {

        return rlb
                .routes()
                .route(p -> p
                                .path("/api/balance/initiate")
                                .filters(f -> f.removeRequestHeader("Cookie")
                                        .rewritePath("/balance-init-service/(?<segment>.*)", "/$\\{segment}")
                                        .filter(authorizationHeaderFilter.apply(new
                                                AuthenticationGatewayFilterFactory.Config())))
                                .uri("lb://balance-init-service")
                )
                .build();
    }
	

}
