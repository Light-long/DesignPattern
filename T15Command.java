package DesignPartten;

/**
 * 命令模式 -- 行为设计模式
 * 将请求转换为一个包含请求相关所有信息的独立对象
 *
 * 根据不同的请求将方法参数化，延迟请求执行或者将其放入队列操作
 *
 * 按钮和命令分开，相关命令绑定到相关按钮上，点击按钮就会执行相关命令
 */
public class T15Command {

    public static void main(String[] args) {
        SaveButton saveButton = new SaveButton();
        TextBox box = new TextBox();

        PrintCommand printCommand = new PrintCommand(box);
        saveButton.bindCommand(printCommand);

        box.setContext("李世龙");
        saveButton.doPrint();
    }
}

interface Command {
    void execute();
}

class PrintCommand implements Command {
    private PrintService printService = new PrintService();
    private TextBox box;

    public PrintCommand(TextBox box) {
        this.box = box;
    }

    @Override
    public void execute() {
        printService.print(box.getContext());
    }
}

/**
 * 图像层
 */
class SaveButton {
    private Command command;

    public void bindCommand(Command command) {
        this.command = command;
    }

    public void doPrint() {
        if (command == null) {
            throw new IllegalArgumentException("初始化失败");
        }
        command.execute();
    }
}

/**
 * 文本内容
 */
class TextBox {
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

/**
 * 服务层
 */
class PrintService {
    public void print(String text) {
        System.out.println("文本内容：" + text);
    }
}




