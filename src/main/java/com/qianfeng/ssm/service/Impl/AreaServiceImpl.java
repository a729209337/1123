package com.qianfeng.ssm.service.Impl;

import com.qianfeng.ssm.mapper.AreaMapper;
import com.qianfeng.ssm.pojo.Area;
import com.qianfeng.ssm.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2019/7/8 0008 19:40
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaMapper areaMapper;

    @Override
    public List<Area> getAllProvince() {
        return areaMapper.getALlProvince();
    }

    @Override
    public List<Area> getCityByName(String name) {
        return areaMapper.getCityByName(name);
    }

    @Override
    public List<Area> getAreaByName(String name) {
        return areaMapper.getAreaByName(name);
    }


}
