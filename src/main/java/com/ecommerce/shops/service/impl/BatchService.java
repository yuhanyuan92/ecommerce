package com.ecommerce.shops.service.impl;

import com.ecommerce.shops.bean.ZbTongji;
import com.ecommerce.shops.service.IBatchService;
import com.ecommerce.shops.service.ITongjiService;
import com.ecommerce.shops.task.ThreadQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: qlm-zxhy
 * @description: 批量查询数据
 * @author: hanyuan.yu
 * @create: 2019/3/1 18:06
 * @Version 1.0
 **/
@Service
public class BatchService implements IBatchService {
    @Autowired
    ITongjiService tongjiService;

    @Override
    public List<ZbTongji> getVariableData() {
        long start = System.currentTimeMillis();
        //返回结果
        List<ZbTongji> list = new ArrayList<>();
        //查到数据总量
        int count = tongjiService.getTotalCount();
        int num = 10000;//每次查询的条数
        //需要查询的次数
        int times = count / num;
        if (count % num != 0) {
            times = times + 1;
        }
        //开始查询的行数
        int bindex = 0;
        List<Callable<List<ZbTongji>>> tasks = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            Callable<List<ZbTongji>> callable = new ThreadQuery(tongjiService, bindex, num);
            tasks.add(callable);
            bindex += num;
        }
        //定义固定长度的线程池  防止线程过多
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        try {
            List<Future<List<ZbTongji>>> futures = executorService.invokeAll(tasks);
            // 处理线程返回结果
            if (futures != null && !futures.isEmpty()) {
                futures.stream().forEach(future -> {
                    try {
                        list.addAll(future.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });
            }
            executorService.shutdown();  // 关闭线程池
            long end = System.currentTimeMillis();
            System.out.println("用时" + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}