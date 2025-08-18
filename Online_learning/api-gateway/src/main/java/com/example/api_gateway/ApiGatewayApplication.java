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
	
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
        		.route("user-service", r -> r.path("/user/**")
        		        .uri("http://localhost:2001"))
        		.route("course-service", r -> r.path("/courses/**")
        				.uri("http://localhost:2002"))
        		.route("classroom_service", r -> r.path("/class/**")
        				.uri("http://localhost:2003"))
        		.route("assessment_service", r -> r.path("/assessments/**")
        				.uri("http://localhost:2004"))
        		.route("notfication-service", r -> r.path("/notifications/**")
        				.uri("http://localhost:2005"))
//                .route("user_service", r -> r.path("/user/**")
//                        .uri("http://localhost:2001"))
//                .route("customer-service", r -> r.path("/api/customers/**")
//                        .uri("http://localhost:2222"))
//                .route("order-service", r -> r.path("/api/orders/**")
//                        .uri("http://localhost:3333"))
//                .route("payment-service",r -> r.path("/api/payment/**")
//                		.uri("http://localhost:2020"))
                
                		
                .build();
    }

}