package com.ecommerce.shops.controller;

import com.alibaba.fastjson.JSON;
import com.ecommerce.shops.bean.User;
import com.ecommerce.shops.bean.resp.Response;
import com.ecommerce.shops.bean.resp.Result;
import com.ecommerce.shops.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: qlm-zxhy
 * @description: TODO
 * @author: hanyuan.yu
 * @create: 2019/1/7 15:17
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @ApiOperation(value = "注册接口", notes = "用户注册接口 返回值code说明：1001 注册成功 1002 该账号已被注册")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public String register(@RequestBody User user) {
        Response<Object> response = new Response<>();
        Map<String, Object> map = userService.register(user);
        Result<Object> result = response.success(map);
        return JSON.toJSONString(result, true);
    }

    @ApiOperation(value = "登陆接口", notes = "用户登陆接口 返回值code说明：1001 登陆成功 1003 用户不存在 1004 密码错误")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "account", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(String account, String password) {
        Response<Object> response = new Response<>();
        Map<String, Object> map = userService.login(account, password);
        Result<Object> result = response.success(map);
        return JSON.toJSONString(result, true);
    }

    @ApiOperation(value = "查询用户接口", notes = "查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "numPerPage", value = "每页记录数", paramType = "path", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "path", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/list/{numPerPage}/{currentPage}", method = {RequestMethod.GET, RequestMethod.POST})
    public String getUserList(@PathVariable Integer numPerPage, @PathVariable Integer currentPage) {
        logger.info("---------------------------获取用户");
        return userService.findUser(numPerPage, currentPage);
    }

}