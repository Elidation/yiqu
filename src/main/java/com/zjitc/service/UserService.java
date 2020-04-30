package com.zjitc.service;

import com.zjitc.bean.UserInfo;
import com.zjitc.pojo.UserAuth;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    //登录
    UserInfo findUserByPhone(String phone);

    //註冊
    void signUp(String phone, String password);

    //更新用户信息

    void updUserInfo(String phone,String truename,String nickname,int gender,String city);

    //用户实名
    void verify(String phone,String truename,Integer sex,String card,String cardaddress,String liveaddress,String stastus);

    //查询用户实名
    UserAuth selectUserAuth(String phone);
    //删除实名信息
    void delUserAuth(String phone);
    //修改密码
    void setPwd(String phone,String password);
}
