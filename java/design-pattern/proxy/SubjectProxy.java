package proxy;

import java.lang.reflect.Proxy;

public class SubjectProxy {

    public static Subject getProxy(Subject s) {
        return (Subject) Proxy.newProxyInstance(
                s.getClass().getClassLoader(),
                s.getClass().getInterfaces(),
                new Invoke(s));
    }


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Subject t = SubjectProxy.getProxy(new SubjectImpl());
        t.test();
        System.out.println(1);
    }
}
