package com.ecommerce.shops.service.impl;

import com.alibaba.fastjson.JSON;
import com.ecommerce.shops.bean.User;
import com.ecommerce.shops.bean.resp.Response;
import com.ecommerce.shops.bean.resp.Result;
import com.ecommerce.shops.mapper.UserMapper;
import com.ecommerce.shops.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ecommerce
 * @description: 用户管理
 * @author: hanyuan.yu
 * @create: 2019/1/9 9:34
 * @Version 1.0
 **/
@Service("userService")
public class UserService implements IUserService, Serializable {

    @Resource
    UserMapper userMapper;

    @Override
    public String findUser(Integer numPerPage, Integer currentPage) {
        Response<List<User>> response = new Response<>();
        Result<List<User>> result = null;
        try {
            int start = (currentPage - 1) * numPerPage;
            List<User> list = userMapper.getUserList(start, numPerPage);
            result = response.success(list);
        } catch (Exception e) {
            result = response.fail();
            e.printStackTrace();
        }
        return JSON.toJSONString(result, true);
    }

    @Override
    public Map<String, Object> insert(User user) {
        Map<String, Object> map = new HashMap<>();
        User source = new User();
        source.setAccount(user.getAccount());
        User oriUser = userMapper.selectByAccount(source);
        if (oriUser != null) {
            map.put("code", "1002");
        } else {
            map.put("code", "1001");
            userMapper.insert(user);
        }
        return map;
    }

    @Override
    public Map<String, Object> login(String account, String password) {
        Map<String, Object> map = new HashMap<>();
        User source = new User();
        source.setAccount(account);
        User user = userMapper.selectByAccount(source);
        if (user != null) {
            user.setPassword(password);
            user = userMapper.selectByAccount(user);
            if (user != null) {
                map.put("user", user);
                map.put("code", "1001");
            } else {
                map.put("code", "1004");
            }
        } else {
            map.put("code", "1003");
        }
        return map;
    }

}