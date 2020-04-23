package com.zjitc.dao;

import com.zjitc.bean.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 数据库交互层
 * */

@Repository
public interface UserDao {

    //登录
    UserInfo findUserByPhone(@Param("phone") String phone);

    //註冊
    void signUp(@Param("phone") String phone, @Param("password") String password);
}

