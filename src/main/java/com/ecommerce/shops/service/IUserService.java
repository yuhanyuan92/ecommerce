package com.ecommerce.shops.service;

import com.ecommerce.shops.bean.User;

import java.util.Map;

public interface IUserService {

    String findUser(Integer numPerPage, Integer currentPage);

    Map<String, Object> insert(User user);

    Map<String, Object> login(String account, String password);
}
