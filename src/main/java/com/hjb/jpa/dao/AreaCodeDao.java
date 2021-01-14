package com.hjb.jpa.dao;

import com.hjb.jpa.entity.AreaCodePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AreaCodeDao extends JpaRepository<AreaCodePojo, String> {

    @Query(nativeQuery = true, value = "select * from area_code")
    List<AreaCodePojo> getAllAreaCode();
}
