package DesignPartten;

/**
 * 访问者模式
 *
 * 封装作用于某种数据结构中的个元素的操作，他可以在不改变数据结构的前提下，定义作用于这些元素的新的操作
 */
public class T23Visitor {
    public static void main(String[] args) {
        EggRobot robot = new EggRobot();
        robot.cal();
        Visitor updatePack = new UpdateVisitor();
        robot.accept(updatePack);
        robot.cal();
    }
}

interface Visitor {
    void visitCPU(CPU cpu);
    void visitDisk(HardDisk disk);
}

// 升级软件包
class UpdateVisitor implements Visitor {

    @Override
    public void visitCPU(CPU cpu) {
        cpu.command += ",1+1=2";
    }

    @Override
    public void visitDisk(HardDisk disk) {
        disk.command += ",记住1+1=2";
    }
}

class EggRobot {
    private CPU cpu;
    private HardDisk disk;

    public EggRobot() {
        cpu = new CPU("1+1=1");
        disk = new HardDisk("记住1+1=1");
    }

    public void cal() {
        cpu.run();
        disk.run();
    }

    public void accept(Visitor visitor) {
        cpu.accept(visitor);
        disk.accept(visitor);
    }
}

abstract class HardWare {
    String command;
    public HardWare(String command) {
        this.command = command;
    }

    public void run() {
        System.out.println(command);
    }

    // 留一个接口，接受之后的新命令
    public abstract void accept(Visitor visitor);
}

class CPU extends HardWare {

    public CPU(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCPU(this);
    }
}

class HardDisk extends HardWare {

    public HardDisk(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDisk(this);
    }
}


