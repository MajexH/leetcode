package command;

public class CommandImpl implements Command {
    // 可以包装一个 命令执行者
    private CommandExecutor commandExecutor;

    public CommandImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void execute(Object args) {
        // 执行
        this.commandExecutor.up();
        // 可以传入
        System.out.println("executed detail here" + args);
    }
}
