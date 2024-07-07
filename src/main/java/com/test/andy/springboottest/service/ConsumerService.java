package com.test.andy.springboottest.service;

import com.test.andy.springboottest.dto.ConsumerRecordDto;
import com.test.andy.springboottest.entity.ConsumerRecord;
import com.test.andy.springboottest.repository.ConsumerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    EmailService emailService;

    public boolean createRecord(ConsumerRecordDto dto) {
        boolean result = false;

        try {
            ConsumerRecord record = new ConsumerRecord();
            record.setName(dto.getName());
            record.setPrice(dto.getPrice());
            record.setConsumerDate(dto.getTime());
            record.setCategory(dto.getCategory());
            record.setDetail(dto.getNote());
            record.setCreateDate(LocalDate.now());
            consumerRepository.save(record);
            result = true;

            // 異步發送郵件通知
            emailService.sendOrderNotification("您有一筆新的訂單", "您有一筆新的訂單");
        } catch (Exception e) {
            log.info("createRecord error: {}", e.getMessage());
        }
        return result;
    }
}
