package com.zjitc.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjitc.pojo.HouseView;
import com.zjitc.service.HouseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/findAllHouse.do")
    public ModelAndView findAllHouse(){
        //查询所有房源信息
        ModelAndView mv=new ModelAndView();
        System.out.println("已进入控制器");
        List<HouseView> newHouse = this.houseService.findAllHouse(0);
        List<HouseView> oldHouse = this.houseService.findAllHouse(1);
        List<HouseView> rentHouse = this.houseService.findAllHouse(2);
        System.out.println(newHouse);
        System.out.println(oldHouse);
        System.out.println(rentHouse);
        mv.addObject("newHouse",newHouse);
        mv.addObject("oldHouse",oldHouse);
        mv.addObject("rentHouse",rentHouse);
        mv.setViewName("/main.jsp");
        return mv;
    }

    @RequestMapping("/findAllHouseInfo.do")
    public ModelAndView findAllHouseInfo(Integer houseType,Integer page,Integer size){
        //查询所有房源信息
        ModelAndView mv=new ModelAndView();
        System.out.println("已进入控制器");
        List<HouseView> house = this.houseService.findAllHouseInfo(page,size,houseType);
        List<HouseView> recommondHouse=this.houseService.findAllHouse(houseType);
        PageInfo<HouseView> pageInfo=new PageInfo<>(house);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("remmondHouse",recommondHouse);
        mv.setViewName("/pages/houses.jsp");
        return mv;
    }

    @RequestMapping("/findHouseById.do")
    public ModelAndView findHouseById(Integer houseId){
        //查询所有房源信息
        ModelAndView mv=new ModelAndView();
        System.out.println("已进入控制器");
        HouseView houseInfo = this.houseService.findHouseById(houseId);
        mv.addObject("houseDetail",houseInfo);
        mv.setViewName("/pages/details.jsp");
        return mv;
    }


}
