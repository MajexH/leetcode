import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private static class R implements Runnable {

        private int start;
        private Writer out;
        private Condition condition1;
        private Condition condition2;

        public R(int start, Writer out, Condition lock, Condition lock1) {
            this.start = start;
            this.out = out;
            this.condition1 = lock;
            condition2 = lock1;
        }

        @Override
        public void run() {

            while (this.start <= 100) {
                try {
                    condition1.await();
                    condition2.signalAll();
                    out.write(this.start);
                    this.start += 2;
                    condition1.signalAll();
                    condition2.await();
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(() -> {
            int start = 0;

            while (start <= 100) {
                try {
                    lock.lock();
                    out.write(String.valueOf(start));
                    c2.await();
                    c1.signalAll();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                start += 2;
            }
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            int start = 1;

            while (start <= 100) {
                try {
                    lock.lock();
                    out.write(String.valueOf(start));
                    c2.signalAll();
                    c1.await();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                start += 2;
            }
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
