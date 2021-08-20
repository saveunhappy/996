package com.imooc.zhangxiaoxi.threadpool2.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVs {

    /**
     * 新的处理方式
     */
    @Test
    public void newHandle() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(()->{
                System.out.println("文档处理开始");
                try {
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            });
        }


        Thread.sleep(1000L * 1000);
    }

    /**
     * 老的处理方式
     */
    @Test
    public void oldHandle() throws InterruptedException {
        /**
         * 使用循环来模拟许多用户请求的场景
         */
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println("文档处理开始");
                try {
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            }).start();
        }
        Thread.sleep(1000L * 1000);
    }

}
