package com.test.andy.springboottest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "消費紀錄 dto")
@Data
public class ConsumerRecordDto {
    private String uuid;

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 10, message = "Name must be between 2 and 10 characters")
    @Schema(description = "消費名稱", example = "Andy")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Schema(description = "費用", example = "120")
    private Integer price;

    @NotNull(message = "Time cannot be null")
    @Schema(description = "消費時間", example = "2024-01-10")
    private LocalDate time;

    @Schema(description = "分類", example = "吃喝")
    private String category;

    @Schema(description = "註記", example = "7-11飲料")
    private String note;
}
