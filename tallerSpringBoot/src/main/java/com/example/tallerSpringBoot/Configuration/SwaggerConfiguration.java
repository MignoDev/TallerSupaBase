package com.example.tallerSpringBoot.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenApi()
    {
        return new OpenAPI().info(new Info()
                .title("API parqueadeor")
                .version("1.0")
                .description("Documentación de la API para gestionar parqueadero")
                .contact(new Contact()
                        .name("Soporte API")
                        .email("mangelbejarano@ucundinamarca.edu.co")));
    }
}
