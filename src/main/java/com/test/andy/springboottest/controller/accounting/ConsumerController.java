package com.test.andy.springboottest.controller.accounting;

import com.test.andy.springboottest.dto.ConsumerRecordDto;
import com.test.andy.springboottest.service.ConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@Slf4j
@Tag(name = "一般消費紀錄")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @Operation(summary = "一般消費記帳")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "紀錄成功"),
            @ApiResponse(responseCode = "500", description = "系統錯誤")
    })
    @PostMapping("/record")
    public ResponseEntity<Boolean> createRecord(@Valid @RequestBody ConsumerRecordDto dto) {
        return ResponseEntity.ok(consumerService.createRecord(dto));
    }
}
