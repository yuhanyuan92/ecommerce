package com.ecommerce.shops;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: qlm-zxhy
 * @description: TODO
 * @author: hanyuan.yu
 * @create: 2019/3/5 21:02
 * @Version 1.0
 **/
public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Future<String> future = service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return Thread.currentThread().getName() + ":hello world";
                }
            });
            list.add(future);
        }
        // 打印结果
        for (Future<String> future : list) {
            System.out.println(future.get());
        }
        // 关闭线程池
        service.shutdown();
    }

}