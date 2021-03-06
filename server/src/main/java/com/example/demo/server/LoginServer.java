package com.example.demo.server;

import com.example.demo.entity.model.BaseResult;
import com.example.demo.entity.model.LoginResult;

public interface LoginServer {
    void login(String loginName, String password, BaseResult<LoginResult> result);
}
