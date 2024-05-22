package com.test.andy.springboottest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "消費紀錄 dto")
@Data
public class ConsumerRecordDto {
    private String uuid;

    @NotNull
    @Schema(description = "消費名稱", example = "Andy")
    private String name;

    @NotNull
    @Schema(description = "費用", example = "120")
    private int price;

    @NotNull
    @Schema(description = "時間", example = "2024-01-10")
    private LocalDate time;

    @Schema(description = "分類", example = "吃喝")
    private String category;

    @Schema(description = "註記", example = "7-11飲料")
    private String note;
}
