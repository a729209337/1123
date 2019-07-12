package com.qianfeng.ssm.mapper;

import com.qianfeng.ssm.pojo.Area;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<Area> getALlProvince();

    List<Area> getCityByName(String name);

    List<Area> getAreaByName(String name);
}