package command;

// 对不同 API 的调用封装成同一个 API
public interface Command {
    // 封装命令的细节
    void execute(Object args);
}
