package com.ecommerce.shops.mapper;

import com.ecommerce.shops.bean.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart findByUser(Cart cart);

    List<Cart> getCartList(Integer userId, Integer start, Integer numPerPage);
}