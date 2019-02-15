package com.ecommerce.shops.controller;

import com.ecommerce.shops.service.IGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: qlm-zxhy
 * @description: 获取商品信息
 * @author: hanyuan.yu
 * @create: 2019/2/15 16:35
 * @Version 1.0
 **/
@Api(description = "商品模块")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IGoodsService goodsService;

    @ApiOperation(value = "获取商品列表接口", notes = "获取商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "numPerPage", value = "每页记录数", paramType = "path", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "path", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/list/{numPerPage}/{currentPage}", method = {RequestMethod.GET, RequestMethod.POST})
    public String getGoodsList(@PathVariable Integer numPerPage, @PathVariable Integer currentPage) {
        return goodsService.findGoods(numPerPage, currentPage);
    }
}