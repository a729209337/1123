package com.qianfeng.ssm.service;
import com.qianfeng.ssm.pojo.Area;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2019/7/8 0008 19:40
 */

public interface AreaService {
    List<Area> getAllProvince();



    List<Area> getCityByName(String name);

    List<Area> getAreaByName(String name);
}
