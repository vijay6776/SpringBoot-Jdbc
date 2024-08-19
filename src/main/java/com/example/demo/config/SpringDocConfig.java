package com.example.demo.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
  
    @Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder()
                .group("3-Spring-Jdbc")
                .packagesToScan("com.example.demo.controller") // Specify the package to scan
                .build();
    }

} 