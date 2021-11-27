package DesignPartten;

/**
 * 模板模式：
 * 定义一个操作中的算法的框架，将步骤延迟到子类中去实现
 * 子类不改变算法的结构，重新实现某些特定的步骤
 *
 * 父类中定义不变的，和整体框架，子类中具体实现步骤
 */
public class T13Template {
    public static void main(String[] args) {
        Cooking cooking = new CookingFood();
        cooking.cook();
    }
}

abstract class Cooking {
    public abstract void step1();
    public abstract void step2();

    public void cook() {
        System.out.println("做饭开始");
        step1();
        step2();
        System.out.println("做饭结束");
    }
}

class CookingFood extends Cooking {

    @Override
    public void step1() {
        System.out.println("准备西红柿和鸡蛋");
    }

    @Override
    public void step2() {
        System.out.println("西红柿炒鸡蛋");
    }
}
