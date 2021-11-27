package DesignPartten;

/**
 * 代理模式：
 * 通过增加代理类来控制对目标类的访问(访问目标类前要做什么，访问目标类之后要做什么)
 *
 * core：控制对目标类的访问，可以增强目标类（Decorator）
 */
public class T11Proxy {
    public static void main(String[] args) {
        new Proxy(new RealSubject()).doWork();
    }
}

interface Subject {
    void doWork();
}

class RealSubject implements Subject {

    @Override
    public void doWork() {
        System.out.println("目标类工作");
    }
}

class Proxy implements Subject {
    // 聚合目标类
    private Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    public void connect() {
        System.out.println("连接");
    }

    public void log() {
        System.out.println("记录日志");
    }

    @Override
    public void doWork() {
       connect();
       subject.doWork();
       log();
    }
}
