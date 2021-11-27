package DesignPartten;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 定义对象间一对多的依赖关系
 * 当被观察对象发生改变时，观察者对象就会得到通知（触发事件）
 * 把观察者添加到一个数据集合中，通知时从集合中取
 */
public class T7Observer {
    public static void main(String[] args) {
        ZhangSan zhangSan = new ZhangSan();
        // 借钱（添加观察者）
        zhangSan.borrow(new WangWu());
        zhangSan.borrow(new LiSi());
        // 有钱了，还钱
        zhangSan.notifyCredits();
    }
}
// 借钱方
interface Debit {
    void borrow(Credit credit);
    void notifyCredits();
}

class ZhangSan implements Debit {
    // 存放观察者的集合
    private final List<Credit> creditList = new ArrayList<>();

    // 添加观察者
    @Override
    public void borrow(Credit credit) {
        creditList.add(credit);
    }

    @Override
    public void notifyCredits() {
        creditList.forEach(Credit::takeMoney);
    }
}

// 债主
interface Credit {
    void takeMoney();
}

class WangWu implements Credit {

    @Override
    public void takeMoney() {
        System.out.println("王五来拿钱");
    }
}

class LiSi implements Credit {

    @Override
    public void takeMoney() {
        System.out.println("李四来拿钱");
    }
}
