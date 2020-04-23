package com.zjitc.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjitc.pojo.HouseView;
import com.zjitc.dao.HouseDao;
import com.zjitc.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;

    @Override
    public List<HouseView> findAllHouse(Integer houseType) {
        return this.houseDao.findAllHouse(houseType);
    }

    @Override
    public List<HouseView> findAllHouseInfo(Integer page,Integer size,Integer houseType) {
        PageHelper.startPage(page,size);
        return this.houseDao.findAllHouseInfo(houseType);
    }

    @Override
    public HouseView findHouseById(Integer houseId) {
        return this.houseDao.findHouseById(houseId);
    }


}
