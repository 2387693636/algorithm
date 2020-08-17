package com.study.pattern.singleton;

/**
 * @author: zou_xq
 * @description: IoDH 延迟加载单例模式  存在问题是：该模式只适用于初始化不能是失败的对象
 * @date: 2020/8/17 11:17
 */
public class IoDHSingleton {
    private IoDHSingleton() {
        //int a = 1 / 0;
    }

    /**  提供一个静态类其中包含一个可以获取实例对象的方法 **/
    private static class Holder {
        private static final IoDHSingleton instance = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance() {
        return Holder.instance;
    }

    public static void main(String[] args) {
        IoDHSingleton instance = IoDHSingleton.getInstance();
        System.out.println("instance:"+instance);
    }
}
