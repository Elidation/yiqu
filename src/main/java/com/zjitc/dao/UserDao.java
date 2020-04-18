package com.zjitc.dao;

import com.zjitc.bean.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * 数据库交互层
 * */

@Repository
public interface UserDao {

    //登录
    UserInfo findUserByPhone(String phone);

}

