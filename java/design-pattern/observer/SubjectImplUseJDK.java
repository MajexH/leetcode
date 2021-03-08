package observer;

import java.util.Observable;

public class SubjectImplUseJDK extends Observable {

    public Object msg;

    public void setMsg(Object msg) {
        this.msg = msg;
        // 1. 要先设置更改
        setChanged();
        // 2. 被动的传递消息
        notifyObservers(msg);
    }
}
