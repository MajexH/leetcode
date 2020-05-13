import java.util.concurrent.locks.ReentrantLock;

public class ThreeThread {
    // 显示地创建三个线程，观察执行顺序
    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("This is thread1");
        }
    });
    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("This is thread2");
        }
    });
    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("This is thread3");
        }
    });
    public static void main(String[] args) throws Exception {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        ReentrantLock lock = new ReentrantLock(true);
    }
}
