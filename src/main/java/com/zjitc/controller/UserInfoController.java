package com.zjitc.controller;

import com.zjitc.bean.UserInfo;
import com.zjitc.service.UserService;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.JsonObject;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService service;

    @RequestMapping("login.do")
    @ResponseBody
    public String login(@Param("phone") String phone, @Param("password") String password, HttpSession session){
        JSONObject jo=new JSONObject();
        UserInfo user = service.findUserByPhone(phone);
        if (user!=null){
            if (user.getPassword().equals(password)){
                System.out.println("登录成功");
                session.setAttribute("user",user);
                jo.put("result","2");
            }else{
                System.out.println("密码错误");
                jo.put("result","1");
            }
        }else{
            System.out.println("用户不存在");
            jo.put("result","0");
        }
        return jo.toString();
    }

    @RequestMapping("/signUp.do")
    @ResponseBody
    public String signUp(@RequestParam("phone") String phone, @RequestParam("password") String password){
        JSONObject jo=new JSONObject();
        UserInfo user = this.service.findUserByPhone(phone);
        if (user!=null){
            System.out.println("用戶已被註冊");
            jo.put("result","0");
        }else {
            System.out.println("註冊成功");
            this.service.signUp(phone,password);
            jo.put("result","1");
        }
        return jo.toString();
    }
}
