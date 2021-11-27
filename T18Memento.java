package DesignPartten;

import java.util.Stack;

/**
 * 备忘录模式 -- 行为设计模式
 *
 * 不暴露对象实现细节的情况下，保存和恢复对象之前的状态
 *
 * 备忘录类来保存本体对象中的成员变量
 */
public class T18Memento {
    public static void main(String[] args) {
        History history = new History();
        Document document = new Document();
        document.change("lishilong");
        // 生成备忘录
        BackUp backUp = document.save();
        // 放入备忘录栈
        history.add(backUp);

        document.change("李世龙");
        history.add(document.save());

        document.change("哈哈哈");

        document.resume(history.getLastVersion());
        document.print();
        document.resume(history.getLastVersion());
        document.print();
    }
}


/**
 * 文档类
 */
class Document {
    // 需要备份的数据
    private String content;

    public BackUp save() {
        return new BackUp(content);
    }

    public void resume(BackUp backUp) {
        content = backUp.content;
    }

    public void change(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }

}

/**
 * 备忘录接口
 * 定义元数据方法
 */
interface Memento {

}


/**
 * 备忘录类
 */
class BackUp implements Memento{
    public String content;

    public BackUp(String content) {
        this.content = content;
    }
}

/**
 * 备忘录栈
 */
class History {
    private Stack<BackUp> backUpStack = new Stack<>();
    public void add(BackUp backUp) {
        backUpStack.push(backUp);
    }

    public BackUp getLastVersion() {
        return backUpStack.pop();
    }
}
