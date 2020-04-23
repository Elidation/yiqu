package com.zjitc.dao;

import com.zjitc.pojo.HouseView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDao {

    //查询房源所有信息
   List<HouseView> findAllHouse(@Param("houseType") Integer houseType);
   List<HouseView> findAllHouseInfo(@Param("houseType") Integer houseType);
   HouseView findHouseById(@Param("houseId")Integer houseId);
}
