package com.ecommerce.shops.service.impl;

import com.alibaba.fastjson.JSON;
import com.ecommerce.shops.bean.Goods;
import com.ecommerce.shops.bean.resp.Response;
import com.ecommerce.shops.bean.resp.Result;
import com.ecommerce.shops.mapper.GoodsMapper;
import com.ecommerce.shops.service.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: qlm-zxhy
 * @description: 商品信息
 * @author: hanyuan.yu
 * @create: 2019/2/15 16:34
 * @Version 1.0
 **/
@Service
public class GoodsService implements IGoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public String findGoods(Integer numPerPage, Integer currentPage) {
        Response<List<Goods>> response = new Response<>();
        Result<List<Goods>> result = null;
        try {
            int start = (currentPage - 1) * numPerPage;
            List<Goods> list = goodsMapper.getGoodsList(start, numPerPage);
            result = response.success(list);
        } catch (Exception e) {
            result = response.fail();
            e.printStackTrace();
        }
        return JSON.toJSONString(result, true);
    }
}