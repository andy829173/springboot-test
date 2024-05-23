package com.test.andy.springboottest.repository;

import com.test.andy.springboottest.entity.ConsumerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerRecord, String> {

}
