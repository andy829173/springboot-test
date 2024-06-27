package com.test.andy.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    /*
     * @Bean 是用於方法級別的註解，用來告訴 Spring 這個方法返回一個 bean 並將其註冊到 Spring 容器中。@Bean 通常與 @Configuration 註解一起使用，來定義 Spring 配置類。
     */
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);  // 設置核心池大小
        executor.setMaxPoolSize(10);  // 設置最大池大小
        executor.setQueueCapacity(25);  // 設置隊列容量
        executor.setThreadNamePrefix("AsyncTaskExecutor-");  // 設置線程名稱前綴
        executor.initialize();
        return executor;
    }
}