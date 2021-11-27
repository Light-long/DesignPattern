package DesignPartten;

/**
 * 状态模式
 *
 * 当一个对象其内部状态发生改变时，改变其行为
 *
 * 步骤：
 * 1. 定义状态接口
 * 2. 状态子类
 * 3. 类中添加状态属性，changeState方法
 * 4. 类中方法调用
 */
public class T9State {
    public static void main(String[] args) {
        Context context = new Context();
        context.chaneState(new Happy());
        context.doSomething();
        context.chaneState(new Sad());
        context.doSomething();
    }
}

interface State {
    void doWork();
}

class Happy implements State {

    @Override
    public void doWork() {
        System.out.println("好好工作");
    }
}

class Sad implements State {

    @Override
    public void doWork() {
        System.out.println("没心情工作");
    }
}

class Context {
    private State state;
    public void chaneState(State state) {
        System.out.println("当前状态是：" + state.getClass().getName());
        this.state = state;
    }

    public void doSomething() {
        state.doWork();
    }
}
