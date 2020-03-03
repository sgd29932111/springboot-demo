package com.example.demo.server.Impl;

import com.example.demo.entity.Users;
import com.example.demo.entity.model.BaseResult;
import com.example.demo.entity.model.LoginResult;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.util.ConstUtil.*;

@Service
public class LoginServerImpl implements LoginServer{

    private UsersMapper usersMapper;

    @Autowired
    public LoginServerImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }


    @Override
    public void login(String loginName, String password, BaseResult<LoginResult> result) {
        try {
            Users users = usersMapper.selectByLoginName(loginName);
            if(users==null){

            }
            LoginResult loginResult = new LoginResult();
            if((password).equals(users.getPsssword())){
                loginResult.setUserId(users.getId());
                result.construct(LOGIN_SUCCESS,true,loginResult);
            }else{
                result.construct(WRONG_PASSWORD,true,loginResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.construct(LOGIN_FAILED,false,null);
        }
    }
}
