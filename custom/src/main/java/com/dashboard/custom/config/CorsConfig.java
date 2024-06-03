package com.dashboard.custom.config;

import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    // implements WebmvcConfigurer
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        CorsRegistration registration = registry.addMapping("/**");
        registration.allowedOrigins("*");
        registration.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
        registration.maxAge(3600);
        registration.allowCredentials(false);
    }


}
