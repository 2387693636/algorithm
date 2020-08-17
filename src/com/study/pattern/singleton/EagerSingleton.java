package com.study.pattern.singleton;

/**
 * @author: zou_xq
 * @description: 饿汉式单例模式;类加载时创建单例对象
 * @date: 2020/8/17 11:00
 */
public class EagerSingleton {
    /** 类加载时创建的 instance 先创建好，用时来取**/
    private static final EagerSingleton instance = new EagerSingleton();
    /** 私有构造函数 **/
    private EagerSingleton() {
    }

    /**
     * 提供的接口
     **/
    private static EagerSingleton getInstance() {
        return instance;
    }
}
