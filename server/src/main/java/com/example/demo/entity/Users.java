package com.example.demo.entity;


import com.example.demo.config.UUIdGenId;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Users")
public class Users {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "user_name")
    private String userName;

    private String psssword;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return login_name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return psssword
     */
    public String getPsssword() {
        return psssword;
    }

    /**
     * @param psssword
     */
    public void setPsssword(String psssword) {
        this.psssword = psssword;
    }

}