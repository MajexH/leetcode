package observer;

public class ObserverImpl implements Observer {

    @Override
    public void update() {
        System.out.println("update");
    }
}
