package DesignPartten;

/**
 * 工厂（方法）模式
 *
 * 将创建对象的工作交给了工厂的子类,由某个工厂创建对应的某个产品
 *
 * 总结：
 * 工厂模式是简单工厂模式的升级版，满足了开闭原则（对扩展开放，对修改关闭）
 * 解决了简单工厂模式的灵活性差的缺点。
 * 工厂模式将创建对象的工作交给了工厂的子类（延迟创建对象），
 * 自己只提供需要子类实现的方法。这样，在需要新增的时候就可以不破坏原来的结构
 *
 * 角色：
 * 1. 父类工厂
 * 2. 具体的子类工厂（多个）
 * 3. 抽象产品
 * 4. 具体子类产品（多个）
 *
 * 局限性：只能创建某一大类产品（手机）下的所有子类产品（华为，苹果）
 */
public class T3Factory {

    public static void main(String[] args) {
        FatherFactory factoryA = new FactoryA();
        factoryA.createProduct().print();
        FatherFactory factoryB = new FactoryB();
        factoryB.createProduct().print();
    }
}

abstract class FatherFactory {
    public abstract FatherProduct createProduct();
}

class FactoryA extends FatherFactory{

    @Override
    public FatherProduct createProduct() {
        return new Product1();
    }
}

class FactoryB extends FatherFactory{

    @Override
    public FatherProduct createProduct() {
        return new Product2();
    }
}

abstract class FatherProduct {
    public abstract void print();
}

class Product1 extends FatherProduct{

    @Override
    public void print() {
        System.out.println("产品1");
    }
}

class Product2 extends FatherProduct{

    @Override
    public void print() {
        System.out.println("产品2");
    }
}
