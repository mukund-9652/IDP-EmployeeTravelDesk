package com.cognizant.employeetraveldesk.reimbursement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Adjust the mapping pattern to match your API endpoints
                .allowedOrigins("http://localhost:4200") // Update with the appropriate origin(s)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the allowed HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow cookies and authentication headers if needed
    }
}
