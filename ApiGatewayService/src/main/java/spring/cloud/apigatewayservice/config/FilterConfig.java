package spring.cloud.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application.yml 의 spring.application.cloud.gateway 부분을 java code 로 이동
//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f
                                .addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("filters-reponse", "first-response-header"))
                        .uri("http://localhost:8081/"))
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f
                                .addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082/"))
                .build();
    }
}
