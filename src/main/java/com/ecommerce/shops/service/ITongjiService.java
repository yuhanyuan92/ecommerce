package com.ecommerce.shops.service;

import com.ecommerce.shops.bean.ZbTongji;

import java.util.List;

public interface ITongjiService {
    int getTotalCount();
    List<ZbTongji> findPageData(Integer start, Integer limit);
}
