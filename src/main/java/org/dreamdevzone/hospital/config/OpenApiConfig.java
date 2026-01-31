package org.dreamdevzone.hospital.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("unused")
public class OpenApiConfig {

    @Bean
    public OpenAPI configureOpenAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Hospital Management System")
                        .version("1.0.0")
                        .description("A REST API for managing the patients, doctors, and staff in any hospital.")
                        .license(new License().name("MIT"))
        );
    }
}
