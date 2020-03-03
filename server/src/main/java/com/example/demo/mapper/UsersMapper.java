package com.example.demo.mapper;

import com.example.demo.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import static com.example.demo.util.ConstUtil.*;

@Repository
public interface UsersMapper extends Mapper<Users> {

    @Select(SQL_SELECT_USER_BY_LOGIN_NAME)
    Users selectByLoginName(@Param(DB_LOGIN_NAME) String loginName);
}