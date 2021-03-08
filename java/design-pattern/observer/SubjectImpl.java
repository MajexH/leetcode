package observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {

    List<Observer> obs;

    public SubjectImpl() {
        this.obs = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer ob) {
        for (Observer registered : obs) {
            if (ob == registered) return;
        }
        this.obs.add(ob);
    }

    @Override
    public void unregisterObserver(Observer ob) {
        this.obs.remove(ob);
    }

    // 在更改某个数值 或者需要通知的时候 可以将结果通知给注册的 observer
    public void setXXX() {
        this.notifyAllObserver();
    }

    @Override
    public void notifyAllObserver() {
        for (Observer registered : obs) {
            registered.update();
        }
    }
}
