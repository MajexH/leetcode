package multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 该工具类在同一时间只允许至多两个线程访问，超过两个线程的将被停止
 * <p>
 * 保证只有两个能够同时获取到锁
 */
public class TwinsLock implements Lock {

    public static void main(String[] args) throws InterruptedException {
        // test

        Lock twinsLock = new TwinsLock();

        for (int i = 0; i < 10; i++) {
            // 同一时间能看到两个打印
            new Thread(() -> {
                try {
                    twinsLock.lock();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                } finally {
                    twinsLock.unlock();
                }
            }).start();
        }

        Thread.currentThread().join();
    }

    private Sync sync;

    private static final class Sync extends AbstractQueuedSynchronizer {

        public Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must larger than or equal to zero");
            }

            this.setState(2);
        }

        @Override
        protected int tryAcquireShared(int required) {
            // 尝试减去 required 的数据
            for (; ; ) {
                int cur = this.getState();
                int next = cur - required;

                // 小于 0 就直接返回 让当前线程堵塞
                // 开始比较设置
                if (next < 0 || this.compareAndSetState(cur, next)) {
                    return next;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
            // 要把 status 加回来
            for (; ; ) {
                int state = this.getState();
                int next = state + returnCount;
                // 如果大于 0 那么就要尝试唤醒
                if (this.compareAndSetState(state, next)) {
                    return true;
                }
            }
        }
    }

    public TwinsLock() {
        this.sync = new Sync(2);
    }

    @Override
    public void lock() {
        this.sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        this.sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
