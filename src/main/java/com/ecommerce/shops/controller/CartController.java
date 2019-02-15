package com.ecommerce.shops.controller;

import com.alibaba.fastjson.JSON;
import com.ecommerce.shops.bean.Cart;
import com.ecommerce.shops.bean.resp.Response;
import com.ecommerce.shops.bean.resp.Result;
import com.ecommerce.shops.service.ICartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: qlm-zxhy
 * @description: 购物车模块
 * @author: hanyuan.yu
 * @create: 2019/1/29 10:24
 * @Version 1.0
 **/
@Api(description = "购物车模块")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService cartService;

    @ApiOperation(value = "新增购物车接口", notes = "添加购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "goodsId", value = "商品id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "count", value = "商品数量", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/addToCart", method = {RequestMethod.GET, RequestMethod.POST})
    public String addToCart(Cart cart) {
        Response<Object> response = new Response<>();
        Result<Object> result = null;
        try {
            if(cart.getUserId() == null || "".equals(cart.getUserId())){
                result = response.fail("用户未登录");
            }else{
                cartService.addToCart(cart);
                result = response.success(null);
            }
        } catch (Exception e) {
            result = response.fail("添加购物车失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(result, true);
    }

}