package com.test.andy.springboottest.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SrpingDocGroupConfig {

    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder()
                .group("test")
                .pathsToMatch("/test/**")
                .build();
    }

    @Bean
    public GroupedOpenApi accountingApi() {
        return GroupedOpenApi.builder()
                .group("計算機")
                .pathsToMatch("/consumer/**", "/login/**")
                .build();
    }
}
