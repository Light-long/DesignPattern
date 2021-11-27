package DesignPartten;

/**
 * 适配器模式
 * 将一个类的接口换成另一个客户端需要的接口（把一个不适配的方法转换成另一个适配的方法）
 * 适配器模式会  改变  原有的实例方法，注意是改变不是新增；
 * 而装饰器模式不会改变原有的实例方法，只会  新增
 */
public class T6Adapter {
    public static void main(String[] args) {
        System.out.println(new Adapter(new Speaker()).translate());
    }
}

class Speaker {
    public String speak() {
        return "Java is the best";
    }
}

interface Translate {
    String translate();
}

class Adapter implements Translate {
    // 聚合需要被适配的类(组件)
    private final Speaker speaker;
    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }
    // 适配
    @Override
    public String translate() {
        String result = speaker.speak();
        result += " language";
        return result;
    }
}
