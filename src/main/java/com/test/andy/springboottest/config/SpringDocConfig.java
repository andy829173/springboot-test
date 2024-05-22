package com.test.andy.springboottest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Swagger 測試")
                .description("SpringBoot 3.x application")
                .version("v0.0.1")
                .contact(new Contact()
                        .name("Andy")
                        .url("aaa")
                        .email("andy.tsai@promeritage.com.tw")));
    }
}