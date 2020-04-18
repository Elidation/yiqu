package com.zjitc.service;

import com.zjitc.bean.UserInfo;

public interface UserService {

    //登录
    UserInfo findUserByPhone(String phone);

}
