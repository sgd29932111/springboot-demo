package com.example.demo.server.Impl;

import com.example.demo.entity.Users;
import com.example.demo.entity.model.BaseResult;
import com.example.demo.entity.model.LoginResult;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.util.ConstUtil.*;

@Service
public class UserServerImpl implements UserServer {

    private UsersMapper usersMapper;

    @Autowired
    public UserServerImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public void register(String loginName, String userName, String password, BaseResult<LoginResult> result) {
        try {
            //先查询用户名是否已经注册过
            Users users = usersMapper.selectByLoginName(loginName);
            if (users == null) {
                users = new Users();
                users.setLoginName(loginName);
                users.setPsssword(password);
                users.setUserName(userName);
                usersMapper.insertSelective(users);
                result.construct(REGISTER_SUCCESS, true, null);
            } else {
                result.construct(LOGIN_NAME_EXISTED, false, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.construct(REGISTER_FAILED, false, null);
        }
    }
}
