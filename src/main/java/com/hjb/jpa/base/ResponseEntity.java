package com.hjb.jpa.base;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

public class ResponseEntity {

    private String requestId = "";

    private Integer code;

    private long costs = -1;

    private String message = "";

    private List<?> data = Lists.newArrayList();

    private JSONObject jsonData;

    public ResponseEntity() {
    }

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(Integer code, String message, List<?> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(Integer code, String message, JSONObject jsonData) {
        this.code = code;
        this.message = message;
        this.jsonData = jsonData;
    }

    public ResponseEntity(Integer code, long costs, String message, List<?> data) {
        this.code = code;
        this.costs = costs;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(String requestId, Integer code, long costs, String message, List<?> data) {
        this.requestId = requestId;
        this.code = code;
        this.costs = costs;
        this.message = message;
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getCosts() {
        return costs;
    }

    public void setCosts(long costs) {
        this.costs = costs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
