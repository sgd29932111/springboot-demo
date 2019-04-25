package com.example.demo.server;

import com.example.demo.entity.model.BaseResult;
import com.example.demo.entity.model.LoginResult;

public interface UserServer {
    void register(String loginName, String userName, String password, BaseResult<LoginResult> result);
}
