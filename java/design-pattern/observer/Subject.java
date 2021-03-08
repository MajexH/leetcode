package observer;

// 需要被观察的主题
public interface Subject {

    void registerObserver(Observer ob);

    void unregisterObserver(Observer ob);

    void notifyAllObserver();
}
