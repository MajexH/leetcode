public class Singleton {

    // 需要被单例的对象
    private static class NeedSingletonClass {
        public int param1;
        public Object param2;
    }

    // 懒汉式是在 <clinit> 的时候创建这个对象，然后访问这个类的时候
    // 直接返回这个对象即可
    public static class LazySingleton {
        private static final NeedSingletonClass singleton = new NeedSingletonClass();
        // 根据 effectiveJava 这个地方可以强制可以不被单例话
        private LazySingleton(){};
        public static NeedSingletonClass getSingleton() {
            return singleton;
        }
    }

    /**
     * 懒汉模式实现单例
     * 饿汉式是在需要的时候直接创建
     * 为了保障线程安全，使用 synchronized 关键字
     */
    public static class HungrySingleton {
        private static NeedSingletonClass singleton;

        public static NeedSingletonClass getSingleton() {
            synchronized (HungrySingleton.class) {
                if (singleton == null) {
                    singleton = new NeedSingletonClass();
                }
                return singleton;
            }
        }
    }

    /**
     * 采用双重检验锁的机制来保障单例模式的线程安全
     */
    public static class DoubleCheckLocking {
        // 防止指令重排序 防止其它线程拿到了未完全初始化的对象
        // 因为一个对象 new 的过程会经历
        // 加载类 -> 开辟空间 -> 初始化0值 -> 填充对象头 -> 调用 <init> 方法
        // 而反应到 java 的指令上
        // 就会有 分配内存 初始化内存 最后将这个对象指向这个内存区域 等
        // 有可能最后一步先执行，然后返回 实际上前面的指令还没执行完 就会爆炸
        private volatile static NeedSingletonClass singletonClass;

        public static NeedSingletonClass getSingletonClass() {
            // 这个地方判断 null 是为了减少进入 synchronized() 使用 mutex 的次数
            // 避免进入系统锁的竞争
            if (singletonClass == null) {
                synchronized (NeedSingletonClass.class) {
                    // 这个地方是为了防止多个线程同时进入 synchronized
                    // 避免进行等待后再初始需要单例的对象
                    if (singletonClass == null) {
                        singletonClass = new NeedSingletonClass();
                    }
                }
            }
            return singletonClass;
        }
    }

    // 使用静态内部类来保障安全
    // 原理是因为 静态内部类是懒加载的
    private static class StaticClassSingleton {

        private StaticClassSingleton() {};

        private static class InnerStaticClass {
            public static NeedSingletonClass singletonClass = new NeedSingletonClass();
        }

        // 这儿是懒加载，在 innerStaticClass 里面的静态内部类被加载的时候
        // 执行内部类的 <clinit> 方法进行初始化
        // final 是为了保证这个方法不会被重写或者重载
        public static final NeedSingletonClass getInstance() {
            return InnerStaticClass.singletonClass;
        }
    }

    public static void main(String[] args) {
//        System.out.println(StaticClassSingleton.getInstance());
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(StaticClassSingleton.getInstance());
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(StaticClassSingleton.getInstance());
        }).start();
    }
}
