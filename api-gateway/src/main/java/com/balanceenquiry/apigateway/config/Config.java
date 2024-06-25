package com.balanceenquiry.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.balanceenquiry.apigateway.filter.AuthenticationFilter;

@Configuration
public class Config {
//	 @Bean
//	   public RouteLocator routeLocator(RouteLocatorBuilder rlb, AuthenticationFilter 
//	   authorizationHeaderFilter) {
//
//	       return rlb
//	               .routes()
//	               .route(p -> p
//	            		.path("/auth/login")
//	                   .filters(f -> f.removeRequestHeader("Cookie")
//	                           .rewritePath("/users-ws/(?<segment>.*)", "/$\\{segment}")
//	                           .filter(authorizationHeaderFilter.apply(new 
//	                        		   AuthenticationFilter.Config())))
//	                .uri("lb://users-ws")
//	            )
//	            .build();
//	     }
}
