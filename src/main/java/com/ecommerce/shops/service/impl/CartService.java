package com.ecommerce.shops.service.impl;

import com.ecommerce.shops.bean.Cart;
import com.ecommerce.shops.mapper.CartMapper;
import com.ecommerce.shops.service.ICartService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: qlm-zxhy
 * @description: 购物车管理
 * @author: hanyuan.yu
 * @create: 2019/1/29 10:47
 * @Version 1.0
 **/
public class CartService implements ICartService {
    @Resource
    CartMapper cartMapper;

    @Override
    public String addToCart(Cart cart) {

        return null;
    }

    @Override
    public Cart findByPrimaryKey(Integer id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    @Override
    public Cart findByUser(Cart cart) {
        return cartMapper.findByUser(cart);
    }

    @Override
    public List<Cart> findCartList(Integer userId) {
        return null;
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        cartMapper.deleteByPrimaryKey(id);
    }
}