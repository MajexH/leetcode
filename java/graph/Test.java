import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class Test {

    public enum TestEnum {
        test() {
            @Override
            void hh() {
                System.out.println("test");
            }
        },
        test2() {
            @Override
            void hh() {
                System.out.println("test1");
            }
        };

        abstract void hh();
    }

    public static void main(String[] args) {
        TestEnum.test.hh();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Runnable odd = () -> {
           try {
               lock.lock();
               for (int i = 1; i <= 100; i += 2) {
                   System.out.println(i);
                   condition.signalAll();
                   condition1.await();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               lock.unlock();
           }
        };
        Runnable even = () -> {
            try {
                lock.lock();
                for (int i = 0; i <= 100; i += 2) {
                    System.out.println(i);
                    condition1.signalAll();
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        new Thread(even).start();
        new Thread(odd).start();

    }
}
