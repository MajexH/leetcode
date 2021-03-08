package decorator;

public class TwoImpl extends TwoAbstract {

    private Base base;

    public TwoImpl(Base base) {
        this.base = base;
    }

    @Override
    public void base() {
        base.base();
        System.out.println("Two");
    }

    @Override
    public void anotherAbstract() {
        System.out.println("another");
    }
}
