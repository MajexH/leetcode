package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invoke implements InvocationHandler {

    private Subject s;

    public Invoke(Subject s) {
        this.s = s;
    }

    // 封装方法调用逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = method.invoke(this.s, args);
        System.out.println("after");
        return res;
    }
}
