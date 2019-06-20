package com.ecommerce.shops.task;

import com.ecommerce.shops.bean.ZbTongji;
import com.ecommerce.shops.service.ITongjiService;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @program: qlm-zxhy
 * @description: 查询线程
 * @author: hanyuan.yu
 * @create: 2019/3/1 17:29
 * @Version 1.0
 **/
public class ThreadQuery implements Callable<List<ZbTongji>> {
    private ITongjiService tongjiService;
    /**
     * 根据情况可以添加查询条件
     */
//    private String condition;
    private int bindex;//分页index
    private int num;//数量

    public ThreadQuery(ITongjiService tongjiService, int bindex, int num) {
        this.tongjiService = tongjiService;
        this.bindex = bindex;
        this.num = num;
    }

    @Override
    public List<ZbTongji> call() throws Exception {
        return tongjiService.findPageData(bindex, num);
    }

}