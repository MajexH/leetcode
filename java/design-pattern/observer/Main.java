package observer;

import java.util.Observable;

public class Main {

    public static void main(String[] args) {
        Subject s = new SubjectImpl();
        for (int i = 0; i < 10; i++) {
            s.registerObserver(new ObserverImpl());
        }
        s.notifyAllObserver();

        SubjectImplUseJDK b = new SubjectImplUseJDK();
        for (int i = 0; i < 10; i++) {
            b.addObserver(new ObserverImplUseJDK());
        }
        b.setMsg("test");
    }
}
