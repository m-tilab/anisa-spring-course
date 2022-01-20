package com.example.springbootrest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact = new Contact();
        contact.setName("Anisa Academy");
        contact.setEmail("INFO@anisa.co.ir");
        contact.setUrl("http://www.anisa.co.ir");

        return new OpenAPI().info(
                new Info().title("Spring Boot Class API")
                        .description("RESTFul API services documentation with OpenAPI 3")
                        .contact(contact)
        );
    }
}
