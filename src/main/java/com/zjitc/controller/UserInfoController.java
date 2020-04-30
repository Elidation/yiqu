package com.zjitc.controller;

import com.zjitc.bean.UserInfo;
import com.zjitc.pojo.UserAuth;
import com.zjitc.service.UserService;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.inject.Default;
import javax.json.JsonObject;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.time.Year;

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
                session.setAttribute("userAuth",this.service.selectUserAuth(phone));
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

    @RequestMapping("/updUserInfo.do")
    public ModelAndView updUserInfo(String phone, String truename, String nickname, Integer gender, String city,HttpSession session
    ){
        System.out.println(phone);
        System.out.println(truename);
        System.out.println(nickname);
        System.out.println(gender);
        System.out.println(city);
        this.service.updUserInfo(phone,truename,nickname,gender,city);
        UserInfo user = this.service.findUserByPhone(phone);
        ModelAndView mv=new ModelAndView();
//        mv.addObject("user",user);
        session.setAttribute("user",user);
        mv.setViewName("redirect:/pages/personal.jsp");
        return mv;
    }

    @RequestMapping("/verify.do")
    public ModelAndView verify(String phone, String truename, Integer sex, String card, String cardaddress, String liveaddress, @RequestParam(defaultValue = "2") String stastus, HttpSession session){
        System.out.println(phone);
        System.out.println(truename);
        System.out.println(sex);
        System.out.println(card);
        System.out.println(cardaddress);
        System.out.println(liveaddress);
        System.out.println(stastus);
        UserAuth ua=this.service.selectUserAuth(phone);
        System.out.println(ua);
        if (ua!=null){
            System.out.println("没有找到");
            session.setAttribute("userAuth",null);
        }else {
            System.out.println("传递中");
            this.service.verify(phone,truename,sex,card,cardaddress,liveaddress,stastus);
            UserAuth userAuth=this.service.selectUserAuth(phone);
            session.setAttribute("userAuth",userAuth);
        }
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:/pages/verify.jsp");
        return mv;
    }

    @RequestMapping("/delUserAuth.do")
    public String delUserAuth(HttpSession session){
        System.out.println("进入");
        UserInfo userInfo=(UserInfo) session.getAttribute("user");
        this.service.delUserAuth(userInfo.getPhone());
        UserAuth userAuth = this.service.selectUserAuth(userInfo.getPhone());
        System.out.println("删除成功");
        session.setAttribute("userAuth",userAuth);
        return "redirect:/pages/verify.jsp";
    }

    @RequestMapping("/setPwd.do")
    public String setPwd(String password,HttpSession session){
        UserInfo userInfo=(UserInfo)session.getAttribute("user");
        this.service.setPwd(userInfo.getPhone(),password);
        System.out.println("更改成功");
        session.setAttribute("user",this.service.findUserByPhone(userInfo.getPhone()));
        return "redirect:/pages/psdsetting.jsp";
    }
}
