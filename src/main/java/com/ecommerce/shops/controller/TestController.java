package com.ecommerce.shops.controller;

import com.alibaba.fastjson.JSON;
import com.ecommerce.shops.bean.resp.Result;
import com.ecommerce.shops.bean.resp.SuccessCode;
import com.ecommerce.shops.filter.NoRepeatSubmit;
import com.ecommerce.shops.mapper.ZbTongjiMapper;
import com.ecommerce.shops.service.IBatchService;
import com.ecommerce.shops.service.impl.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: qlm-zxhy
 * @description: 表单重复提交测试类
 * @author: hanyuan.yu
 * @create: 2019/1/30 11:28
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    IBatchService batchService;

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    @NoRepeatSubmit
    public String test() {
        Result result = new Result(SuccessCode.SUCCESS.getCode(), SuccessCode.SUCCESS.getMessage());
        System.out.println("-------------------------啊啊啊啊啊");
        return JSON.toJSONString(result, true);
    }

    
}