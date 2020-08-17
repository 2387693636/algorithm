package com.study.pattern.strategy;

/**
 * @author: zou_xq
 * @description: 策略模式之抽象策略角色，用于定义每个策略或者算法必须具有的方法和属性
 * @date: $date$ $time$
 */
public  abstract class StrategyPattern {
    /**
     * 运算方法
     */
    public abstract void testAlgorithmInterface();
}
class Context{
    StrategyPattern strategyPattern;

    public Context(StrategyPattern strategyPattern) {
        this.strategyPattern = strategyPattern;
    }

    /**
     * 上下文接口
     */
    public void contextInterface() {
        //调用抽象策略对象的运算方法
        strategyPattern.testAlgorithmInterface();
    }
}

class AddAlgorithm extends StrategyPattern {
    @Override
    public void testAlgorithmInterface() {
        //重写基类的运算方法
        System.out.println("这是加法运算法则！");
    }
}

class ReduceAlgorithm extends StrategyPattern {
    @Override
    public void testAlgorithmInterface() {
        //重写基类的运算方法
        System.out.println("这是减法运算法则！");
    }
}

class MultiplicationAlgorithm extends StrategyPattern {
    @Override
    public void testAlgorithmInterface() {
        //重写基类的运算方法
        System.out.println("这是乘法运算法则！");
    }
}
class Client{
    public static void main(String[] args) {
        Context context;
        context = new Context(new AddAlgorithm());
        context.contextInterface();

        context = new Context(new ReduceAlgorithm());
        context.contextInterface();

        context = new Context(new MultiplicationAlgorithm());
        context.contextInterface();
    }
}
