package DesignPartten;

import lombok.Builder;
import lombok.Data;

/**
 * 生成器模式
 *
 * 将构建一个复杂对象分成多个步骤
 */
public class T16Builder {

    public static void main(String[] args) {
        House house = House.builder()
                .base(new Base())
                .wall(new Wall())
                .window(new Window())
                .build();
    }
}

@Data
@Builder
class House {
    private Base base;
    private Wall wall;
    private Window window;
}

class Base {

}

class Wall {

}

class Window {

}
