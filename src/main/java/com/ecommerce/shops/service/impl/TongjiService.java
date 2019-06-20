package com.ecommerce.shops.service.impl;

import com.ecommerce.shops.bean.ZbTongji;
import com.ecommerce.shops.mapper.ZbTongjiMapper;
import com.ecommerce.shops.service.ITongjiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: qlm-zxhy
 * @description: 处理大量数据demo
 * @author: hanyuan.yu
 * @create: 2019/3/1 17:00
 * @Version 1.0
 **/
@Service
public class TongjiService implements ITongjiService {
    @Resource
    ZbTongjiMapper tongjiMapper;

    @Override
    public int getTotalCount() {
        return tongjiMapper.getTotalCount();
    }

    @Override
    public List<ZbTongji> findPageData(Integer start, Integer limit) {
        return tongjiMapper.findPageData(start, limit);
    }
}