package status;

public class SoldOutState implements State {

    private Context context;

    public SoldOutState(Context context) {
        this.context = context;
    }

    @Override
    public void insertQuarter() throws Exception {
        throw new RuntimeException("已经售罄");
    }

    @Override
    public void turnCrank() throws Exception {
        throw new RuntimeException("已经售罄");
    }

    @Override
    public void ejectQuarter() throws Exception {
        throw new RuntimeException("已经售罄");
    }

    @Override
    public void dispense() throws Exception {
        throw new RuntimeException("已经售罄");
    }
}
