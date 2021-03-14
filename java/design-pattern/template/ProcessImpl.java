package template;

// 这样可以保证底层组件 只需要关注实现方法细节 不需要关注其他
public class ProcessImpl  extends AbstractProcess {
    @Override
    public void actionThree() {
        System.out.println("process");
    }

    @Override
    public void hook() {
        System.out.println("hook");
    }
}
