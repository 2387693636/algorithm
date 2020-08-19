package com.study.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: zou_xq
 * @description: 线程池的单例模式
 * @date: 2020/8/19 16:53
 */
public class ThreadPoolSingleton {

    private ExecutorService executorService;

    private final int anInt = Runtime.getRuntime().availableProcessors();

    private ThreadPoolSingleton() {
        if (executorService == null) {
            int coreNum = anInt / 2;
            int maxPro = (anInt * 2 + 1) * 2;
            executorService = new ThreadPoolExecutor(coreNum > 2 ? 2 : coreNum, maxPro, 67L,
                    TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        }
    }

    private static ThreadPoolSingleton instance;

    private static ThreadPoolSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadPoolSingleton();
        }
        return instance;
    }

    int executeThreadNum = 1;

    public void executeTask(Runnable runnable) {
        executorService.execute(runnable);
    }
}