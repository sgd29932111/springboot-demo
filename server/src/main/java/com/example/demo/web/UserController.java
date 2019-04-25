package com.example.demo.web;

import com.example.demo.entity.model.BaseResult;
import com.example.demo.entity.model.LoginResult;
import com.example.demo.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.demo.util.ConstUtil.*;

@Controller
@RequestMapping(USER_INTERFACE)
public class UserController {

    private UserServer userServer;

    @Autowired
    public UserController(UserServer userServer) {
        this.userServer = userServer;
    }

    @ResponseBody
    @RequestMapping(REGISTER)
    public BaseResult<LoginResult> register(@RequestParam String loginName, @RequestParam String password,@RequestParam String userName){
        BaseResult<LoginResult> result = new BaseResult<>();
        userServer.register(loginName,userName,password,result);
        return result;
    }
}
