package DesignPartten;

/**
 * 简单工厂模式
 *
 * 属于：创建型设计模式
 * 实现：
 *  1. 可以根据参数，返回不同的实例
 *  2. 专门创建一个类，来创建某个类的不同实例，不同实例具有相同的父类
 *
 * 简单工厂中的角色：
 * 1. 抽象产品类
 * 2. 多个产品子类
 * 3. 工厂类
 *
 * 总结：根据传入的参数不同创建不同的对象
 * 优点：用户不需要关注创建对象的细节
 * 缺点：不够灵活，有新产品加入的时候，需要修改工厂类
 */
public class T2SimpleFactory {
    public static void main(String[] args) {
        Factory.createProduct("A").print();
        Factory.createProduct("B").print();
        Factory.createProduct("C").print();
    }
}

/**
 * 简单工厂
 */
class Factory {

    private static Product product;

    public static Product createProduct(String type) {
        if ("A".equals(type)) {
             product = new ProductA();
        } else if ("B".equals(type)) {
            product = new ProductB();
        } else {
            throw new IllegalArgumentException("没有该类型产品");
        }
        return product;
    }
}

/**
 * 抽象产品
 */
abstract class Product {
    public abstract void print();
}

class ProductA extends Product{

    @Override
    public void print() {
        System.out.println("ProductA");
    }
}

class ProductB extends Product{

    @Override
    public void print() {
        System.out.println("ProductB");
    }
}

