package com.zjitc.dao;

import com.zjitc.bean.UserInfo;
import com.zjitc.pojo.UserAuth;
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

    //更新用户信息
    void updUserInfo(@Param("phone") String phone,@Param("truename") String truename,@Param("nickname") String nickname,@Param("gender") Integer gender,@Param("city") String city);

    //用户实名
    void verify(@Param("phone")String phone,@Param("truename")String truename,@Param("gender")Integer sex,@Param("card")String card,@Param("cardaddress")String cardaddress,@Param("liveaddress")String liveaddress,@Param("stastus")String stastus);

    //查询用户实名
    UserAuth selectUserAuth(@Param("phone")String phone);

    //删除实名信息
    void delUserAuth(@Param("phone")String phone);

    //修改密码
    void setPwd(@Param("phone")String phone,@Param("password")String password);
}

