package DesignPartten;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式 -- 行为设计模式
 * 限制对象之间的直接交互，让他们通过中介者进行合作
 */
public class T22Mediator {
    public static void main(String[] args) {
        Agency marryAgency = new MarryAgency();
        // 男嘉宾
        Person p = new Person("lishilong", 21, Sex.MALE, 20, marryAgency);
        // 女
        Person baby = new Person("ab", 20, Sex.FEMALE, 21, marryAgency);
        Person haha = new Person("haha", 23, Sex.FEMALE, 21, marryAgency);

        marryAgency.pair(p);
    }
}

/**
 * 中介者接口
 */
interface Agency {
    // 匹配
    void pair(Person person);
    // 注册
    void register(Person person);
}

/**
 * 中介者
 */
class MarryAgency implements Agency {
    List<Person> people = new ArrayList<>();

    @Override
    public void pair(Person person) {
        for (Person p : people) {
            if (p.age == person.requiredAge && p.sex != person.sex) {
                System.out.println(p.name + "和" + person.getName() + "匹配成功");
            }
        }
    }

    @Override
    public void register(Person person) {
        people.add(person);
    }
}

/**
 * 参与者
 */
@Data
class Person {
    String name;
    int age;
    Sex sex;
    int requiredAge;
    Agency agency;

    public Person(String name, int age, Sex sex, int requiredAge, Agency agency) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.requiredAge = requiredAge;
        this.agency = agency;
        // 注册
        agency.register(this);
    }

    public void find() {
        agency.pair(this);
    }

}

enum Sex {
    MALE, FEMALE
}
