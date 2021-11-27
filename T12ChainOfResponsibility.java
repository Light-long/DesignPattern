package DesignPartten;

/**
 * 责任链模式
 * 把多个处理器连成链，让请求在链上传递，直到其中的某个处理成功
 *
 * 优点：将请求和处理分开，请求者不需要知道谁去处理
 * 缺点：降低系统性能（需要从链头走到链尾，直到有handler处理）
 */
public class T12ChainOfResponsibility {
    public static void main(String[] args) {
        Handler leader = new Leader();
        Handler boss = new Boss();
        leader.setNextHandler(new Boss());
        leader.process(5);
        leader.process(10);
    }
}

abstract class Handler {
    protected Handler nextHandler;
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void process(Integer info);
}

class Leader extends Handler {
    @Override
    public void process(Integer info) {
        if (info > 0 && info < 10) {
            System.out.println("Leader 处理！！");
        } else {
            nextHandler.process(info);
        }
    }
}

class Boss extends Handler {

    @Override
    public void process(Integer info) {
        System.out.println("Boss 处理！！！");
    }
}
