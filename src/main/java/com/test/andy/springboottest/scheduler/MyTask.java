package com.test.andy.springboottest.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/*
 * @Component 用於類級別，將該類註冊為 Spring bean。
 * @Component 必須與 @ComponentScan 一起使用，Spring 才能自動掃描和註冊該 bean。
 */
@Component
public class MyTask {
    @Scheduled(cron = "0 * * * * *", zone = "Asia/Taipei")
    public void everyMinutes() {
        Instant now = Instant.now();
        System.out.println("every minutes / " + now.toString());
    }
}
