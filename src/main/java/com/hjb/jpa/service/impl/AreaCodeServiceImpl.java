package com.hjb.jpa.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hjb.jpa.base.ResponseEntity;
import com.hjb.jpa.dao.AreaCodeDao;
import com.hjb.jpa.entity.AreaCodePojo;
import com.hjb.jpa.service.AreaCodeService;
import com.hjb.jpa.tools.ResponseState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaCodeServiceImpl implements AreaCodeService {
    @Resource
    private AreaCodeDao areaCodeDao;

    @Override
    public ResponseEntity getAllAreaCode() {
        List<AreaCodePojo> list = areaCodeDao.getAllAreaCode();
        JSONArray array = new JSONArray();
        Map<String, String> map = new HashMap<>();
        list.forEach(item -> {
            JSONObject json = new JSONObject();
            json.put("id", item.getAreaCode());
            json.put("value", item.getProvince() + " " + item.getCity() + " " + item.getAreaName());
            array.add(json);
        });
        return new ResponseEntity(ResponseState.EXECUTE_OK, ResponseState.QUERY_OK, array);
    }
}
