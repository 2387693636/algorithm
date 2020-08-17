package com.study.pattern.factory;

/**
 * @author: zou_xq
 * @description: 抽象工厂模式
 * 最大的好处便是易于交换产品系列，由于具体工厂类，
 * 在一个应用中只需要在初始化的时候出现一次，这就使得改变一个应用的具体工厂变得非常容易，
 * 它只需要改变具体工厂即可使用不同产品配置。
 * @date: 2020/8/11 15:01
 */
public interface AbstractFactoryPattern {
    /** 定义各种生产产品的方法工厂 */
    public ProductA factoryA();
    public ProductB factoryB();
    public ProductC factoryC();
}
/** 具体工厂（生产等级为1的A产品）**/
class ConcreateFactory1 implements AbstractFactoryPattern {

    @Override
    public ProductA factoryA() {
        return new CreateA();
    }

    @Override
    public ProductB factoryB() {
        return null;
    }

    @Override
    public ProductC factoryC() {
        return null;
    }

    public static void main(String[] args) {
        ConcreateFactory1 factoryA = new ConcreateFactory1();
        ProductA productA = factoryA.factoryA();
        productA.methodA1();
        productA.methodA2();
    }
}

interface ProductA {
    public void methodA1();
    public void methodA2();
}

interface ProductB {
    public void methodB1();
    public void methodB2();
}

interface ProductC {
    public void methodC1();
    public void methodC2();
}

/**
 * 生产A的具体产品
 */
class CreateA implements ProductA {

    @Override
    public void methodA1() {
        System.out.println("methodA1生产等级为1的A产品信息");
    }

    @Override
    public void methodA2() {
        System.out.println("methodA2生产等级为2的A产品信息");
    }
}


