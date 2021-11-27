package DesignPartten;

/**
 * 外观模式（中介模式）
 * 增加一个统一对外的接口，封装了原系统的多次调用，减低复杂性
 * eg. 一键三连，只需要长按点赞
 * 缺点：不符合开闭原则
 */
public class T8Facade {
    public static void main(String[] args) {
        boolean result = new Facade().sanLian();
        System.out.println(result);
    }
}

class Facade {
    // 引入子系统
    private final SubSys1 s1 = new SubSys1();
    private final SubSys2 s2 = new SubSys2();
    private final SubSys3 s3 = new SubSys3();

    public boolean sanLian() {
        return s1.isLike() && s2.isCollection() && s3.isCoinOperated();
    }
}

class SubSys1 {
    public boolean isLike() {
        return true;
    }
}

class SubSys2 {
    public boolean isCollection() {
        return true;
    }
}

class SubSys3 {
    public boolean isCoinOperated() {
        return true;
    }
}
