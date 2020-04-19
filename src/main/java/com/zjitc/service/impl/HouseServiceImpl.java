package com.zjitc.service.impl;

import com.zjitc.bean.HouseView;
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
}
