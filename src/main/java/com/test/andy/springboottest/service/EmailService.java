package com.test.andy.springboottest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    // 測試 TaskExecutor 用
    @Async
    public void sendOrderNotification(String orderDetails) {
        // 模擬發送郵件的延遲
        try {
            Thread.sleep(3000); // 假設發送郵件需要3秒
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        // 發送郵件的邏輯
        System.out.println("Email sent for order: " + orderDetails);
    }
}
