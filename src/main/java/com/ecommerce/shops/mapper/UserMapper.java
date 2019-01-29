package com.ecommerce.shops.mapper;

import com.ecommerce.shops.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    User selectByAccount(User user);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    List<User> getUserList(@Param("start")Integer start, @Param("limit")Integer limit);

}