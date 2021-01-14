package com.hjb.jpa.controller;

import com.alibaba.fastjson.JSONObject;
import com.hjb.jpa.base.ResponseEntity;
import com.hjb.jpa.entity.UserPojo;
import com.hjb.jpa.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @return ResponseEntity对象
     */
    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public ResponseEntity login(HttpServletRequest request, @Param(value = "userName") String userName, @Param(value = "password") String password) {
        String url = request.getServletPath();
        return userService.login(url, userName, password);
    }

    /**
     * 注册
     * @param params 注册参数
     * @return ResponseEntity对象
     */
    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public ResponseEntity register(@Param(value = "params") String params) {
        return userService.register(JSONObject.parseObject(params));
    }
}
