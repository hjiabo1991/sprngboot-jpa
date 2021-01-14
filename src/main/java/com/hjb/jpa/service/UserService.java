package com.hjb.jpa.service;

import com.alibaba.fastjson.JSONObject;
import com.hjb.jpa.base.ResponseEntity;
import com.hjb.jpa.entity.UserPojo;


public interface UserService {

    ResponseEntity login(String url, String userName, String password);

    ResponseEntity register(JSONObject params);
}
