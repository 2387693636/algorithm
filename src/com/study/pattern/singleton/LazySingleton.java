package com.study.pattern.singleton;

/**
 * @author: zou_xq
 * @description: 懒汉式 延迟加载
 * @date: 2020/8/17 11:04
 */
public class LazySingleton {
    private LazySingleton() {
    }

    private static LazySingleton instance = null;

    /**
     * 懒汉式的话是需要的话调用getInstance()方法时 才创建实例对象
     * @return
     */
    synchronized public static LazySingleton getInstance() {
        if (instance == null) {
            return instance= new LazySingleton();
        }
        return instance;
    }

    /**
     * 应对多个线程同时调用getInstance()方法采用 synchronized
     */
//    synchronized public static LazySingleton getInstance() {
//        if (instance == null) {
//            return instance = new LazySingleton();
//        }
//        return instance;
//    }

    /**
     * 懒汉式双重检验锁  Double-Check Locking
     */
//    private LazySingleton() {
//    }
//
//    private volatile LazySingleton instance = null;
//
//    public static LazySingleton getInstance() {
//        if (instance == null) {
//            synchronized (LazySingleton.class){
//                if (instance == null) {
//                    instance = new LazySingleton();
//                }
//            }
//        }
//        return instance;
//    }

}
