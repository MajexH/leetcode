package status;

public interface State {

    void insertQuarter() throws Exception;

    void turnCrank() throws Exception;

    void ejectQuarter() throws Exception;

    void dispense() throws Exception;
}
