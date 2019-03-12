package com.ecommerce.shops.controller;

import com.ecommerce.shops.bean.ZbTongji;
import com.ecommerce.shops.service.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: qlm-zxhy
 * @description: 招标统计
 * @author: hanyuan.yu
 * @create: 2019/3/12 9:37
 * @Version 1.0
 **/
@RestController
@RequestMapping("/tongJi")
public class TongjiController {
    @Autowired
    IBatchService batchService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllZbData(){
        List<ZbTongji> list = batchService.getVariableData();
        int size = list.size();
        System.out.println("totalCount:" + size + list.get(size - 1).toString());
        return "success";
    }

}