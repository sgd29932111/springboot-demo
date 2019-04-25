package com.example.demo.server.Impl;

import com.example.demo.entity.model.BaseResult;
import com.example.demo.entity.model.LoginResult;
import com.example.demo.server.LoginServer;
import org.springframework.stereotype.Service;

import static com.example.demo.util.ConstUtil.*;

@Service
public class LoginServerImpl implements LoginServer{
    @Override
    public void login(String userName, String password, BaseResult<LoginResult> result) {
        try {
            LoginResult loginResult = new LoginResult();
            if(("123").equals(userName)&&("123").equals(password)){
                loginResult.setUserId("123");
            }
            result.construct(LOGIN_SUCCESS,true,loginResult);
        } catch (Exception e) {
            e.printStackTrace();
            result.construct(LOGIN_FAILED,false,null);
        }
    }
}
