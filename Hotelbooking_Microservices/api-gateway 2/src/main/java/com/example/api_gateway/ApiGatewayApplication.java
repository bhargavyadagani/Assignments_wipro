package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
//	@Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//        		.route("booking-service",r ->r.path("/api/bookings/**")
//                		.uri("http://localhost:4545"))
//                .route("movie-service", r -> r.path("/api/movie/**")
//                        .uri("http://localhost:2222"))
//                .route("product-service",r -> r.path("/api/**")
//                		.uri("http://localhost:2424"))
//                .route("cuatomer-service",r -> r.path("/api/customers/**")
//                		.uri("http://localhost:3434"))
//                
//                
//                
//                .build();
//    }
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
        		.route("book-service",r ->r.path("/bookings/**")
                		.uri("http://localhost:5656"))
                .route("hotel-service", r -> r.path("/hotels/**")
                        .uri("http://localhost:8989"))
                .route("cust-service",r -> r.path("/customers/**")
                		.uri("http://localhost:6767"))
                .route("room-service",r -> r.path("/rooms/**")
                		.uri("http://localhost:7878"))
                
                
                
                .build();
    }

}
