package com.zjitc.dao;

import com.zjitc.bean.UserInfo;

/**
 * 数据库交互层
 * */
public interface UserDao {

    //登录
    UserInfo findUserByPhone(String phone);

}

