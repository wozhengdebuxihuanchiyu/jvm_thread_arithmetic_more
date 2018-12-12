package com.yu.threadpool;

import java.util.concurrent.*;

/**
 * 线程池代理
 */
public class ThreadProxy {


    ThreadPoolExecutor threadPoolExecutor =
    new ThreadPoolExecutor(
            10, //核心线程数
            20,//最大线程数
            1, //当线程数大于corePoolSize，又没有新的线程提交，线程保存的时间
            TimeUnit.HOURS, //保存时间的单位
            new ArrayBlockingQueue(30), //阻塞队列
            Executors.defaultThreadFactory(), //线程工厂
            new ThreadPoolExecutor.CallerRunsPolicy() //阻塞队列满同时大于maximumPoolSize，抛出的异常
    );

    //public void*/

    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(-1 << COUNT_BITS);
        System.out.println((-1 << COUNT_BITS) | 0);
        System.out.println((1 << COUNT_BITS) - 1);
    }
}
