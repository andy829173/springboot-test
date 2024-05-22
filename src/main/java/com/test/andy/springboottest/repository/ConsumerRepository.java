package com.test.andy.springboottest.repository;

import com.test.andy.springboottest.aop.annotation.TracedFunction;
import com.test.andy.springboottest.entity.ConsumerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@TracedFunction("消費紀錄")
@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerRecord, String> {

}
