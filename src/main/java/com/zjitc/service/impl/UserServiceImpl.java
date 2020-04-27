package com.zjitc.service.impl;

import com.zjitc.bean.UserInfo;
import com.zjitc.dao.UserDao;
import com.zjitc.pojo.UserAuth;
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

    @Override
    public void signUp(String phone, String password) {
        dao.signUp(phone,password);
    }

    @Override
    public void updUserInfo(String phone,String truename, String nickname, int gender, String city) {
        dao.updUserInfo(phone,truename,nickname,gender,city);
    }

    @Override
    public void verify(String phone, String truename, Integer sex, String card, String cardaddress, String liveaddress,String stastus) {
        dao.verify(phone,truename,sex,card,cardaddress,liveaddress,stastus);
    }

    @Override
    public UserAuth selectUserAuth(String phone) {
        return dao.selectUserAuth(phone);
    }
}
