package DesignPartten;

/**
 * 单例模式
 */
public class T1Singleton {

    /**
     * 确保一个类只有一个实例，自行实例化并向整个系统提供这个实例
     *
     * 优点：
     *  1. 只有一个实例，节约系统资源
     * 缺点：
     *  1. 可拓展性差
     *  2. 状态可能会丢失（值被改了）
     * 使用场景：
     *  1. 网站人数统计，全局唯一
     *  2. 实现连接池，线程池
     */
}

/**
 * 饿汉式
 */
class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}

/**
 * 懒汉式
 */
class LazySingleton {
    private static LazySingleton instance = null;
    private LazySingleton() {}

    public synchronized static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * DCL双重检索模式
 */
class DCL {
    /**
     * volatile禁止指令重排，避免出现空指针（a线程只是分配了内存还没有实例化对象）
     */
    private volatile static DCL instance = null;
    private DCL() {}

    public static DCL getInstance() {
        if (instance == null) {
            synchronized (DCL.class) {
                if (instance == null) {
                    instance = new DCL();
                }
            }
        }
        return instance;
    }
}
