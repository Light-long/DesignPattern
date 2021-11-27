package DesignPartten;

/**
 * 原型模式 -- 创建型设计模式
 *
 * 复制一个一模一样的对象（浅拷贝）
 *
 * 缺点：clone逻辑比较复杂
 */
public class T17Prototype {
    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.getName() + ":" + plane.getType());
        Plane clone =(Plane) plane.clone();
        System.out.println(plane.getName() + ":" + plane.getType());
    }
}

interface Prototype {
    Object clone();
}

class Plane implements Prototype{
    private String name;
    private String type;

    public Plane() {
        name = "Name" + Math.random();
        type = "Type" + Math.random();
    }

    public Plane(Plane plane) {
        this.name = plane.name;
        this.type = plane.type;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }


    @Override
    public Object clone() {
        return new Plane(this);
    }
}
