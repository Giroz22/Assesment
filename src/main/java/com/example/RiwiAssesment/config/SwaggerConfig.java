package com.example.RiwiAssesment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Multimedia content management API")
                        .version("1.0")
                        .description("Multimedia content management API for virtual classrooms to enable RIWI to efficiently store and manage classes, lessons and multimedia materials."));
    }
}
