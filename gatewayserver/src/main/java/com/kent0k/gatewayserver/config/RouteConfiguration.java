package com.kent0k.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    /**
     * Add new custom microservices routes for RouteLocator.
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator myCarRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/my-car/cars/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/my-car/cars/(?<segment>,*)", "/${segment}"))
                        .uri("lb://CARS"))
                .route(predicateSpec -> predicateSpec
                        .path("/my-car/customers/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/my-car/customers/(?<segment>,*)", "/${segment}"))
                        .uri("lb://CUSTOMERS"))
                .route(predicateSpec -> predicateSpec
                        .path("/my-car/servicepartners/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/my-car/servicepartners/(?<segment>,*)", "/${segment}"))
                        .uri("lb://SERVICEPARTNERS")).build();
    }
}
