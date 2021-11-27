package DesignPartten;

/**
 * 桥接模式
 * 将抽象 和 实现解耦，使两者能够独立变化
 * 将继承关系 --> 关联关系 （降低耦合）
 *
 * 优点：解耦
 * 缺点：需要较高的抽象能力
 */
public class T21Bridge {
    public static void main(String[] args) {
        new YanWo(new Online()).doWork();
    }
}

/**
 * 抽象类
 */
class YanWo {
    private XiaoShouQuDao quDao;
    public YanWo(XiaoShouQuDao quDao) {
        this.quDao = quDao;
    }

    public void doWork() {
        this.quDao.doSomething();
    }
}

/**
 * 实现接口
 */
interface XiaoShouQuDao {
    void doSomething();
}

/**
 * 实现类
 */
class Online implements XiaoShouQuDao {

    @Override
    public void doSomething() {
        System.out.println("线上销售");
    }
}
