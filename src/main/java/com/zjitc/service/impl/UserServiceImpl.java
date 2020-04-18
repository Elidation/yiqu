package com.zjitc.service.impl;

import com.zjitc.bean.UserInfo;
import com.zjitc.dao.UserDao;
import com.zjitc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public UserInfo findUserByPhone(String phone) {
        return dao.findUserByPhone(phone);
    }
}
