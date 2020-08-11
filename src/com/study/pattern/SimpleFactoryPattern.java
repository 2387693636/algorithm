package com.study.pattern;

/**
 * @author: zou_xq
 * @description: 简单工厂模式 定义一个工厂类，他可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类
 * @date: 2020/8/11 14:58
 */
public class SimpleFactoryPattern {
    /**
     * 工厂可以根据参数的不同返回不同的产品，这就是简单工厂模式
     * 模拟女娲造人
     */
    public static HumanBean produceHuman(String gender)throws Exception {
        //输入 M 生产male , F生产 female
        if ("M".equals(gender)) {
            System.out.println("女娲造了一个M");
            return new Male();
        } else if ("F".equals(gender)) {
            System.out.println("女娲造了一个F");
            return new FeMale();
        }else {
            System.out.println("女娲造了一个啥？");
            throw new Exception("母鸡");
        }
    }
}

class SimpleFactoryClient{
    public static void main(String[] args)  {
        try {
            HumanBean humanBean = SimpleFactoryPattern.produceHuman("5");
            humanBean.makeHuman();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

interface  HumanBean{
    public void makeHuman();
}
/**
 * 简单工厂方法模式可能会产生很多这样的方法
 */
class Male implements HumanBean {
    @Override
    public void makeHuman() {
        System.out.println("男人");
    }
}
class FeMale implements HumanBean {
    @Override
    public void makeHuman() {
        System.out.println("女人");
    }
}
