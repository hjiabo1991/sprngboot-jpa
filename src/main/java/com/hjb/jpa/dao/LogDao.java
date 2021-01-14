package com.hjb.jpa.dao;

import com.hjb.jpa.entity.LogPojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDao extends JpaRepository<LogPojo, Long> {

}
