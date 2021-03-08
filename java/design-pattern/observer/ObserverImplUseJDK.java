package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverImplUseJDK implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        // 可以通过 arg 接受 notify 的消息
        System.out.println("update" + arg);
    }
}
