package status;

public class HasQuarterState implements State {

    // 暴露 context 是为了能够在 state 中操作 context 进行状态转移
    private Context context;

    public HasQuarterState(Context context) {
        this.context = context;
    }

    @Override
    public void insertQuarter() throws Exception {
        throw new RuntimeException("无法重复投币");
    }

    @Override
    public void turnCrank() throws Exception {
        this.context.setCurrentState(context.getSoldState());
    }

    @Override
    public void ejectQuarter() throws Exception {
        this.context.setCurrentState(context.getNoQuarterState());
    }

    @Override
    public void dispense() throws Exception {
        throw new RuntimeException("还未 turn crank 无法获取");
    }
}
