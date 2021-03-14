package template;

// 定义抽象的流程
public abstract class AbstractProcess implements Action {

    // 保障子类的行为有一定的共同性

    // 提供 action 的默认实现
    public void actionOne() {
        System.out.println("One");
    }

    // 提供 action 的默认实现
    public void actionTwo() {
        System.out.println("Two");
    }

    // 可以再次提供 abstract 的默认实现
    public abstract void actionThree();

    // 可以在子类中实现 hook 方法 hook 住 act 执行的过程
    public abstract void hook();

    @Override
    public void act() {
        // 封装整体的算法调用逻辑
        // 根据运行时 动态的选择方法表里面的方法
        actionOne();
        actionTwo();
        actionThree();
        hook();
    }
}
