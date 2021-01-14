package com.hjb.jpa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hjb.jpa.base.ResponseEntity;
import com.hjb.jpa.dao.LogDao;
import com.hjb.jpa.dao.UserDao;
import com.hjb.jpa.entity.LogPojo;
import com.hjb.jpa.entity.UserPojo;
import com.hjb.jpa.service.UserService;
import com.hjb.jpa.tools.ResponseState;
import com.hjb.jpa.tools.TimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSONObject.*;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private LogDao logDao;

    @Resource
    private UserDao userDao;
    @Override
    public ResponseEntity login(String url, String userName, String password) {
        // 查询用户是否存在
        long startTime = System.currentTimeMillis();
        UserPojo flag = userDao.findByUserName(userName);
        if (flag == null) {
            return new ResponseEntity(ResponseState.EXECUTE_ERROR, "用户名不存在");
        } else {
            UserPojo flag2 = userDao.findByUserNameAndPassword(userName, password);
            if (flag2 == null) {
                return new ResponseEntity(ResponseState.EXECUTE_ERROR, "密码错误");
            }
            if ("1".equals(flag2.getState())) {
                return new ResponseEntity(ResponseState.EXECUTE_ERROR, "账号未激活, 请联系审批员!");
            }
            // 根据账号查询用户角色
            List<Map> userRole = userDao.selectUserRole(flag2.getUserId());
            System.out.println("--->" + userRole);
                long endTime = System.currentTimeMillis();
                logDao.save(new LogPojo(flag2.getUserId(), url, TimeUtils.transDate(new Date(), "yyyy-MM-dd HH:mm:ss"), endTime - startTime));
                return new ResponseEntity(ResponseState.EXECUTE_OK, ResponseState.QUERY_OK);

        }

    }

    @Override
    public ResponseEntity register(JSONObject params) {
        UserPojo userPojo = toJavaObject(params, UserPojo.class);
        // 查询该用户是否被注册过
        UserPojo flag = userDao.findByUserName(params.get("userName").toString());
        if (flag == null) {
            userPojo.setCreateTime(TimeUtils.transDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            userDao.save(userPojo);
            return new ResponseEntity(ResponseState.EXECUTE_OK, "注册成功, 请联系审批员审批!");
        } else {
            return new ResponseEntity(ResponseState.EXECUTE_ERROR, ResponseState.ERROR_MESSAGE);
        }
    }
}
