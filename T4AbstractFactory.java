package DesignPartten;

/**
 * 抽象工厂
 *
 * 可以生产多个大类产品
 * 工厂模式只生产一大类对象，而抽象工厂可以生产好几大类对象
 *
 * 角色：
 * 1. 抽象工厂
 * 2. 具体工厂
 * 3. 多个大类产品
 * 4. 对应的多个子类产品
 *
 * 总结：
 * 1. 简单工厂。生产一种产品。需要新增其他种类产品时需要修改工厂实例的代码（违背开闭原则）
 * 2. 工厂（方法）模式。不同的工厂生产不同的产品，一个工厂生产一种产品。（但是这些产品都是一个大类，手机）
 *    需要新增其他种类产品时需要实例对应的工厂，产品过多的话工厂数量暴增，不增加复杂度，难以维护和理解。
 * 3. 抽象工厂模式：可以生产多个大类的对应的不同子类产品
 */
public class T4AbstractFactory {

    public static void main(String[] args) {
        AbstractFactory huaWeiFactory = new HuaWeiFactory();
        huaWeiFactory.createPhone().printPhone();
        huaWeiFactory.createIPad().printPad();
    }
}

abstract class AbstractFactory {
    public abstract Phone createPhone();
    public abstract Pad createIPad();
}

class HuaWeiFactory extends AbstractFactory{

    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Pad createIPad() {
        return new HuaWeiPad();
    }
}

class AppleFactory extends AbstractFactory{

    @Override
    public Phone createPhone() {
        return new iPhone();
    }

    @Override
    public Pad createIPad() {
        return new IPad();
    }
}

abstract class Phone {
    public abstract void printPhone();
}

class HuaWeiPhone extends Phone{

    @Override
    public void printPhone() {
        System.out.println("华为Phone");
    }
}

class iPhone extends Phone{

    @Override
    public void printPhone() {
        System.out.println("iPhone");
    }
}

abstract class Pad {
    public abstract void printPad();
}

class HuaWeiPad extends Pad{

    @Override
    public void printPad() {
        System.out.println("HuaWeiPad");
    }
}

class IPad extends Pad {

    @Override
    public void printPad() {
        System.out.println("IPad");
    }
}
