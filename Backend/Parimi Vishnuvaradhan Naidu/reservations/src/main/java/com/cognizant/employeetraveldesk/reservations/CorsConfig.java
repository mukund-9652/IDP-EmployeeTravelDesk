package com.cognizant.employeetraveldesk.reservations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200") // Set the allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Set the allowed HTTP methods
                .allowedHeaders("*") // Set the allowed headers
                .allowCredentials(true); // Enable CORS with credentials
    }
}
