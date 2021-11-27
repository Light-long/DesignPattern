package DesignPartten;

import java.util.HashSet;
import java.util.Set;

/**
 * 享元模式
 * 运用共享技术，对资源进行有效复用，减少对象的创建（池化技术）
 *
 * 对象的内部状态和外部状态分离，外部状态由客户端指定，内部状态自己维护
 *
 * 缺点：逻辑复杂，状态需要指定
 */
public class T14FlyWeight {

    public static void main(String[] args) {
        BikeFlyWeightFactory bikeFactory = BikeFlyWeightFactory.getInstance();
        BikeFlyWeight bike1 = bikeFactory.getBike();
        bike1.ride("李世龙");
        // bike1.back();

        BikeFlyWeight bike2 = bikeFactory.getBike();
        bike2.ride("吕召莹");
        bike2.back();

        BikeFlyWeight bike3 = bikeFactory.getBike();
        bike3.ride("哈哈哈");
        bike3.back();

        System.out.println(bike1 == bike2);
        System.out.println(bike3 == bike2);
    }

}

abstract class BikeFlyWeight {
    // 内部状态，0未使用，1使用中
    protected Integer state = 0;

    // 外部状态
    abstract void ride(String userName);
    abstract void back();

    public Integer getState() {
        return state;
    }
}

class MobileFlyWeight extends BikeFlyWeight {

    // 新的内部状态，车号
    private Integer bikeId;

    public MobileFlyWeight(Integer bikeId) {
        this.bikeId = bikeId;
    }

    @Override
    void ride(String userName) {
        state = 1;
        System.out.println("姓名：" + userName + "，正在使用" + bikeId + "号单车");
    }

    @Override
    void back() {
        state = 0;
    }
}

// 享元工厂
class BikeFlyWeightFactory {
    // 饿汉式创建单例享元工厂
    public static BikeFlyWeightFactory instance = new BikeFlyWeightFactory();
    public Set<BikeFlyWeight> pool = new HashSet<>();

    public static BikeFlyWeightFactory getInstance() {
        return instance;
    }

    // 初始化池子
    private BikeFlyWeightFactory() {
        for (int i = 0; i < 2; i++) {
            pool.add(new MobileFlyWeight(i));
        }
    }

    // 获取bike
    public BikeFlyWeight getBike() {
        for (BikeFlyWeight bike : pool) {
            if (bike.getState() == 0) {
                return bike;
            }
        }
        return null;
    }
}

