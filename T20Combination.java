package DesignPartten;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式你 -- 结构型设计模式
 * 将对象组合成树形结构，并像当成独立对象使用（组合体也有像独立对象一样的方法）
 */
public class T20Combination {
    public static void main(String[] args) {
        Composite china = new Composite();
        // 北京
        china.add(new City(500));
        // 上海
        china.add(new City(300));

        Composite zheJiang = new Composite();
        // 杭州
        zheJiang.add(new City(200));
        // 无锡
        zheJiang.add(new City(100));

        china.add(zheJiang);

        System.out.println(china.count());
    }
}

/**
 * 统计接口
 */
interface Counter {
    int count();
}

/**
 * 叶子节点
 */
class City implements Counter {
    private int sum = 0;

    public City(int sum) {
        this.sum = sum;
    }

    @Override
    public int count() {
        return sum;
    }
}

/**
 * 组合容器,包含多个叶子（city）
 */
class Composite implements Counter {
    // 包括多个city,多态
    // private List<City> counterList = new ArrayList<>();
    private List<Counter> counterList = new ArrayList<>();

    public void add(Counter counter) {
        counterList.add(counter);
    }

    public void delete(Counter counter) {
        counterList.remove(counter);
    }

    public List<Counter> getChildren() {
        return counterList;
    }

    @Override
    public int count() {
        int sum = 0;
        for (Counter counter : counterList) {
            sum += counter.count();
        }
        return sum;
    }
}
