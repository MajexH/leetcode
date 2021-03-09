package command;

// client 是远程的调用端
public class Client {

    private CommandManager manager;

    public Client(CommandManager manager) {
        this.manager = manager;
    }

    public void execute(int id, Object args) {
        this.manager.execute(id, args);
    }
}
