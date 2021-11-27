package DesignPartten;

/**
 * 装饰器模式是在 原有类的基础上动态添加新的功能，(拿到一个对象，然后对其拓展)
 * 这种添加功能的方式不同于继承，它是在对象层面实现功能扩展，而不是继承的类层面，
 * 因此说装饰器模式比继承更加灵活。
 * 另外，装饰器模式属于结构型设计模式。结构型可以理解为构建更大的类或类对象
 *
 * core: 关注点是增强
 *
 */
public class T5Decorator {
    public static void main(String[] args) {
        new RobotDecorator(new FirstRobot()).doMore();
    }
}

interface Robot {
    void doSomething();
}

class FirstRobot implements Robot{

    @Override
    public void doSomething() {
        System.out.println("唱歌");
        System.out.println("跳舞");
    }
}

class RobotDecorator implements Robot {
    private final Robot robot;
    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMore() {
        robot.doSomething();
        System.out.println("扫地");
    }
}


