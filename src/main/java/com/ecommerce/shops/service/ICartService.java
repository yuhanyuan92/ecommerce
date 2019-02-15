package com.ecommerce.shops.service;

import com.ecommerce.shops.bean.Cart;

import java.util.List;

public interface ICartService {
    /**
     * 添加购物车
     * @param cart
     * @return
     */
    void addToCart(Cart cart);

    /**
     * 获取购物车信息
     * @param id
     * @return
     */
    Cart findByPrimaryKey(Integer id);

    /**
     * @param cart
     * @return
     */
    Cart findByUser(Cart cart);

    /**
     * 获取用户购物车列表
     * @param userId
     * @return
     */
    List<Cart> findCartList(Integer userId);

    /**
     * 删除购物车
     * @param id
     */
    void deleteByPrimaryKey(Integer id);

    /**
     * 获取用户购物车列表
     * @param userId
     * @param numPerPage
     * @param currentPage
     * @return
     */
    String findCart(Integer userId, Integer numPerPage, Integer currentPage);
}
