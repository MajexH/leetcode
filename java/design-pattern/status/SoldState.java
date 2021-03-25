package status;

public class SoldState implements State {

    private Context context;

    public SoldState(Context context) {
        this.context = context;
    }

    @Override
    public void insertQuarter() throws Exception {
        throw new RuntimeException("请先 dispense");
    }

    @Override
    public void turnCrank() throws Exception {
        throw new RuntimeException("请先 dispense");
    }

    @Override
    public void ejectQuarter() throws Exception {
        throw new RuntimeException("请先 dispense");
    }

    @Override
    public void dispense() throws Exception {
        if (this.context.getCount() > 0) {
            this.context.releaseCount();
            if (this.context.getCount() == 0) this.context.setCurrentState(this.context.getSoldState());
            else this.context.setCurrentState(this.context.getNoQuarterState());
            return;
        }
        throw new RuntimeException("已经没有资源了");
    }
}
