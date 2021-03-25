package status;

public class Context implements State {

    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldOutState;
    private final State soldState;

    private State currentState;
    private int count;

    public Context(int count) {
        this.count = count;
        this.hasQuarterState = new HasQuarterState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);

        this.currentState = this.noQuarterState;
    }

    // 表示剩余资源的数量 进行减一操作
    public void releaseCount() {
        this.count--;
    }

    public int getCount() {
        return count;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    // 暴露 state 的操作
    @Override
    public void insertQuarter() throws Exception {
        this.currentState.insertQuarter();
    }

    @Override
    public void turnCrank() throws Exception {
        this.currentState.turnCrank();
    }

    @Override
    public void ejectQuarter() throws Exception {
        this.currentState.ejectQuarter();
    }

    @Override
    public void dispense() throws Exception {
        this.currentState.dispense();
    }

    @Override
    public String toString() {
        return "Context{" +
                "currentState=" + currentState +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        State c = new Context(5);
        try {
            c.insertQuarter();
            c.turnCrank();
            c.dispense();
            System.out.println(c);
            c.insertQuarter();
            c.ejectQuarter();
//            c.turnCrank();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
