package com.zjitc.dao;

import com.zjitc.bean.HouseView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDao {

    //查询房源所有信息
   List<HouseView> findAllHouse(@Param("houseType") Integer houseType);

}
