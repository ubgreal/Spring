package com.example.sesiones._5_6.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Swagger configuration to generate the API REST documentation.
 *
 * HTML: http://localhost:8080/swagger-ui/
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot API REST",
                "Library Api rest docs",
                "1.0",
                "http://www.google.com",
                new Contact("Unai","http://www.google.com","unai@example.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }
}

