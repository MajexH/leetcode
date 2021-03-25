package status;

public class NoQuarterState implements State {

    private Context context;

    public NoQuarterState(Context context) {
        this.context = context;
    }

    @Override
    public void insertQuarter() throws Exception {
        this.context.setCurrentState(this.context.getHasQuarterState());
    }

    @Override
    public void turnCrank() throws Exception {
        throw new RuntimeException("没有投币");
    }

    @Override
    public void ejectQuarter() throws Exception {
        throw new RuntimeException("没有投币");
    }

    @Override
    public void dispense() throws Exception {
        throw new RuntimeException("没有投币");
    }
}
