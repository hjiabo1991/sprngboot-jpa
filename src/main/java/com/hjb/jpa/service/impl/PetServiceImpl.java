package com.hjb.jpa.service.impl;

import com.hjb.jpa.base.ResponseEntity;
import com.hjb.jpa.dao.PetDao;
import com.hjb.jpa.entity.Pet;
import com.hjb.jpa.service.PetService;
import com.hjb.jpa.tools.BeanHelperUtils;
import com.hjb.jpa.tools.ResponseState;
import com.hjb.jpa.tools.TimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Resource
    private PetDao petDao;

    @Override
    public ResponseEntity findAllPets() {
        Long startTime = TimeUtils.getCurrentSeconds();
        List<Pet> data;
        try  {
            data = petDao.findAll();
        } catch (Exception e) {
            return new ResponseEntity(ResponseState.EXECUTE_ERROR, ResponseState.ERROR_MESSAGE);
        }
        Long endTime = TimeUtils.getCurrentSeconds();
        if (BeanHelperUtils.isNullOrEmpty(data)) {
            return new ResponseEntity(ResponseState.EXECUTE_OK, ResponseState.NULL_DATA);
        }
        return new ResponseEntity(ResponseState.EXECUTE_OK,endTime - startTime, ResponseState.QUERY_OK, data);
    }

    @Override
    public ResponseEntity findByColor(String color) {
        Long startTime = TimeUtils.getCurrentSeconds();
        List<Pet> data;
        try {
            data = petDao.findByColor(color);
        } catch (Exception e) {
            return new ResponseEntity(ResponseState.EXECUTE_ERROR, ResponseState.ERROR_MESSAGE);
        }
        if (BeanHelperUtils.isNullOrEmpty(data)) {
            return new ResponseEntity(ResponseState.EXECUTE_OK, ResponseState.NULL_DATA);
        }
        Long endTime = TimeUtils.getCurrentSeconds();
        return new ResponseEntity(ResponseState.EXECUTE_OK,endTime - startTime, ResponseState.QUERY_OK, data);
    }

    @Override
    public ResponseEntity findByPnameAndAndColor(String pname, String color) {
        Long startTime = TimeUtils.getCurrentSeconds();
        List<Pet> data;
        try {
            data = petDao.findByPnameAndAndColor(pname, color);
        } catch (Exception e) {
            return new ResponseEntity(ResponseState.EXECUTE_ERROR, ResponseState.ERROR_MESSAGE);
        }
        if (BeanHelperUtils.isNullOrEmpty(data)) {
            return new ResponseEntity(ResponseState.EXECUTE_OK, ResponseState.NULL_DATA);
        }
        Long endTime = TimeUtils.getCurrentSeconds();
        return new ResponseEntity(ResponseState.EXECUTE_OK,endTime - startTime, ResponseState.QUERY_OK, data);
    }

    @Override
    public ResponseEntity findByIdBetweenOrderById(Integer minId, Integer maxId) {
        Long startTime = TimeUtils.getCurrentSeconds();
        List<Pet> data;
        try {
            data = petDao.findByIdBetweenOrderById(minId, maxId);
        } catch (Exception e) {
            return new ResponseEntity(ResponseState.EXECUTE_ERROR, ResponseState.ERROR_MESSAGE);
        }
        if (BeanHelperUtils.isNullOrEmpty(data)) {
            return new ResponseEntity(ResponseState.EXECUTE_OK, ResponseState.NULL_DATA);
        }
        return new ResponseEntity(ResponseState.EXECUTE_OK, ResponseState.QUERY_OK, data);
    }
}
