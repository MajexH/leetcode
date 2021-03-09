package command;

// 管理并初始化所有的 command 对象
public class CommandManager {

    private Command[] commands;

    public CommandManager() {
        this.commands = new Command[1];
        this.commands[0] = new CommandImpl(new CommandExecutor());
    }

    // 根据传入的 command id 与 args 具体执行
    public void execute(int commandID, Object args) {
        this.commands[commandID].execute(args);
    }
}
