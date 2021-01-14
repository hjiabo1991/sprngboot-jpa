package com.hjb.jpa.tools;

import javax.persistence.criteria.CriteriaBuilder;

public class ResponseState {

    /*
    执行成功状态码
     */
    public static final Integer EXECUTE_OK = 200;
    // 查询成功
    public static final String QUERY_OK = "查询成功";
    // 插入成功
    public static final String INSERT_OK = "插入成功";
    // 更新成功
    public static final String UPDATE_OK = "更新成功";
    // 删除成功
    public static final String DELETE_OK = "删除成功";


    /*
    服务器内部异常
     */
    public static final Integer EXECUTE_ERROR = 500;
    // 执行异常
    public static final String ERROR_MESSAGE = "执行失败";

    /*
    参数有误
     */
    public static final Integer PARAM_ERROR = 400;


    // 暂无数据
    public static final String NULL_DATA = "暂无数据";



}
