package com.zjitc.service;

import com.zjitc.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    //登录
    UserInfo findUserByPhone(String phone);

    //註冊
    void signUp(String phone, String password);
}
