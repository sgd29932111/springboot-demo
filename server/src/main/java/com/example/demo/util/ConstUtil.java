package com.example.demo.util;

public class ConstUtil {
    public static final String LOGIN_INTERFACE = "login";
    public static final String USER_INTERFACE = "user";
    public static final String USER_LOGIN = "/login.do";
    //user
    public static final String REGISTER = "/register";
    //常用返回信息
    public static final String LOGIN_SUCCESS = "登陆成功";
    public static final String LOGIN_FAILED = "登陆失败";
    public static final String LOGIN_NAME_EXISTED = "用户名已存在";
    public static final String REGISTER_SUCCESS = "注册成功";
    public static final String REGISTER_FAILED = "注册失败";

    //user sql
    public static final String SQL_SELECT_USER_BY_LOGIN_NAME = "select * from Users";

    //db
    public static final String DB_LOGIN_NAME = "loginName";
}
