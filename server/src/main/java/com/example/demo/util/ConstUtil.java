package com.example.demo.util;

public class ConstUtil {
    public static final String LOGIN_INTERFACE = "login";
    public static final String USER_INTERFACE = "user";
    public static final String TABLE_INTERFACE = "table";
    public static final String USER_LOGIN = "/login.do";
    //user
    public static final String REGISTER = "/register";
    //table
    public static final String TABLE_GET_TABLE_RECORD=  "/getTableRecord";
    //常用返回信息
    public static final String LOGIN_SUCCESS = "登陆成功";
    public static final String LOGIN_FAILED = "登陆失败";
    public static final String LOGIN_NAME_EXISTED = "用户名已存在";
    public static final String REGISTER_SUCCESS = "注册成功";
    public static final String REGISTER_FAILED = "注册失败";
    public static final String WRONG_PASSWORD = "密码错误";
    public static final String NO_EXISTED_USER = "不存在的用户";
    public static final String FIND_SUCCESS = "查询成功";

    //user sql
    public static final String SQL_SELECT_USER_BY_LOGIN_NAME = "select * from Users where loginName = :loginName ";

    //db
    public static final String DB_LOGIN_NAME = "loginName";
}
