package com.test.andy.springboottest.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "CONSUMER_RECORD")
public class ConsumerRecord {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

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

}
