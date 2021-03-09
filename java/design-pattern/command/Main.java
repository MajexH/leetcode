package command;

public class Main {

    public static void main(String[] args) {
        Client a = new Client(new CommandManager());

        a.execute(0, "hh");
    }
}
