package com.zjitc.service;

import com.zjitc.bean.HouseView;

import java.util.List;

public interface HouseService {


    //查询房源所有信息
    List<HouseView> findAllHouse(Integer houseType);

}
