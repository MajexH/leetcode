import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition firstRun = lock.newCondition();
        Condition secondRun = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                for (char i = 'a'; i <= 'z'; i++) {
                    while (flag) {
                        firstRun.await();
                    }
                    flag = true;
                    System.out.print(i);
                    secondRun.signalAll();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 1; i <= 26; i++) {
                    while (!flag) {
                        secondRun.await();
                    }
                    flag = false;
                    System.out.print(i);
                    firstRun.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
