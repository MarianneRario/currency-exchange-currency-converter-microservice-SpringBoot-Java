package com.rariom.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    // customize the routes
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        // custom routing
        return builder.routes()
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(predicateSpec -> predicateSpec.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(predicateSpec -> predicateSpec.path("/currency-conversion-feign/**") // now working
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-feign/(?<segment>.*)", // custom url (kung ano gusto mo)
                                "/currency-conversion/${segment}")) // saan mare redirect
                        .uri("lb://currency-conversion"))
                .build();
    }
}
// OLD URLs
// http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/PHP
// http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/PHP/quantity/10
// http://localhost:8765/currency-conversion/currency-conversion/feign/from/USD/to/PHP/quantity/10

// NEW URLs
// http://localhost:8765/currency-exchange/from/USD/to/PHP
// http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/PHP/quantity/10
// http://localhost:8765/currency-conversion/currency-conversion/feign/from/USD/to/PHP/quantity/10