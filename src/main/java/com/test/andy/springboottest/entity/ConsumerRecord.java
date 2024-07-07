package com.test.andy.springboottest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "CONSUMER_RECORD")
public class ConsumerRecord {
    @Id
    @GeneratedValue
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "CONSUMER_DATE")
    private LocalDate consumerDate;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "CREATE_DATE")
    private LocalDate createDate;
}
