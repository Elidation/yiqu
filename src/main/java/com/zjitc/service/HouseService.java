package com.zjitc.service;

import com.zjitc.pojo.HouseView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseService {


    //查询房源所有信息
    List<HouseView> findAllHouse(Integer houseType);

    List<HouseView> findAllHouseInfo(Integer page,Integer size,Integer houseType);

    HouseView findHouseById(@Param("houseId")Integer houseId);

}
