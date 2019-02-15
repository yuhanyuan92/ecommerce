package com.ecommerce.shops.service.impl;

import com.alibaba.fastjson.JSON;
import com.ecommerce.shops.bean.Cart;
import com.ecommerce.shops.bean.User;
import com.ecommerce.shops.bean.resp.Response;
import com.ecommerce.shops.bean.resp.Result;
import com.ecommerce.shops.mapper.CartMapper;
import com.ecommerce.shops.service.ICartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: qlm-zxhy
 * @description: 购物车管理
 * @author: hanyuan.yu
 * @create: 2019/1/29 10:47
 * @Version 1.0
 **/
@Service
public class CartService implements ICartService {
    @Resource
    CartMapper cartMapper;

    @Override
    public void addToCart(Cart cart) {
        Cart dest = findByUser(cart);
        if (dest != null) {
            dest.setCount(dest.getCount() + cart.getCount());
            cartMapper.updateByPrimaryKey(dest);
        } else {
            cartMapper.insertSelective(cart);
        }
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

    @Override
    public String findCart(Integer userId, Integer numPerPage, Integer currentPage) {
        Response<List<Cart>> response = new Response<>();
        Result<List<Cart>> result = null;
        try {
            int start = (currentPage - 1) * numPerPage;
            List<Cart> list = cartMapper.getCartList(userId, start, numPerPage);
            result = response.success(list);
        } catch (Exception e) {
            result = response.fail();
            e.printStackTrace();
        }
        return JSON.toJSONString(result, true);
    }
}