package com.example.demo.web;

import com.example.demo.entity.model.BaseResult;
import com.example.demo.entity.model.LoginResult;
import com.example.demo.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.example.demo.util.ConstUtil.*;

@Controller
@RequestMapping(LOGIN_INTERFACE)
public class LoginController {
    private LoginServer loginServer;

    @Autowired
    public LoginController(LoginServer loginServer) {
        this.loginServer = loginServer;
    }

    @ResponseBody
    @RequestMapping(USER_LOGIN)
    public BaseResult<LoginResult> login(@RequestParam String userName,@RequestParam String password){
        BaseResult<LoginResult> result = new BaseResult<>();
        loginServer.login(userName,password,result);
        return result;
    }
}
