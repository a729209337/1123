package com.qianfeng.ssm.controller;

import com.qianfeng.ssm.pojo.Area;
import com.qianfeng.ssm.service.AreaService;
import com.qianfeng.ssm.utils.JedisClientPool;
import com.qianfeng.ssm.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2019/7/8 0008 20:06
 */
@Controller
@ResponseBody
public class AreaController {

    @Autowired
    AreaService areaService;

    @Autowired
    JedisClientPool jedisClientPool;

    @RequestMapping(value = "province.do",produces = {"text/html;charset=utf-8"})
    public String getAllProvince(){


        String provinceList = jedisClientPool.get("province");
        List<Area> areaList = null;


        if (provinceList == null || provinceList == ""){

           areaList = areaService.getAllProvince();

            provinceList = JsonUtils.objectToJson(areaList);

            jedisClientPool.set("province", provinceList);

            System.out.println("省份从mysql中取值");
        } else {
            System.out.println("省份从redis中取值");
        }


        return provinceList;
    }

    @RequestMapping(value = "city.do",produces = {"text/html;charset=utf-8"})
    public String getCityByPid(String name){

        String Name = name + 1;
        //List<Area> areaList = areaService.getCityByName(name);

        String cityList = jedisClientPool.get(Name);
        List<Area> areaList = null;


        if (cityList == null || cityList == ""){

            areaList = areaService.getCityByName(name);

            cityList = JsonUtils.objectToJson(areaList);

            jedisClientPool.set(Name, cityList);

            System.out.println("市从mysql中取值");
        } else {
            System.out.println("市从redis中取值");
        }


        return cityList;

    }
    @RequestMapping(value = "area.do",produces = {"text/html;charset=utf-8"})
    public String getAreaBycity(String name){

        String Name = name + 2;


       // List<Area> areaList = areaService.getAreaByName(name);
        String xianList = jedisClientPool.get(Name);
        List<Area> areaList = null;


        if (xianList == null || xianList == ""){

            areaList = areaService.getAreaByName(name);

            xianList = JsonUtils.objectToJson(areaList);

            jedisClientPool.set(Name, xianList);

            System.out.println("县从mysql中取值");
        } else {
            System.out.println("县从redis中取值");
        }


        return xianList;


    }



}
