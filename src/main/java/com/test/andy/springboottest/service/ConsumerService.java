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

    public boolean createRecord(ConsumerRecordDto dto) {
        boolean result = false;

        try {
            ConsumerRecord record = new ConsumerRecord();
            record.setName(dto.getName());
            record.setPrice(dto.getPrice());
            record.setConsumerDate(LocalDate.now());
            record.setCategory(dto.getCategory());
            record.setDetail(dto.getNote());
            consumerRepository.save(record);
            result = true;
        } catch (Exception e) {
            log.info("createRecord error: {}", e.getMessage());
        }
        return result;
    }
}
