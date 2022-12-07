package multiThread;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    public static final class Connection {}

    private final List<Connection> pool = new ArrayList<>();

    public void init(int size) {
        synchronized (this.pool) {
            for (int i = 0; i < size; i++) {
                this.pool.add(new Connection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        synchronized (this.pool) {
            this.pool.add(connection);
            // 发送已经有资源的通知
            this.pool.notifyAll();
        }
    }

    public Connection getConnect(long mill) throws InterruptedException {
        synchronized (this.pool) {
            if (mill <= 0) {
                while (this.pool.isEmpty()) {
                    // 让出锁
                    this.pool.wait();
                }
                return this.pool.remove(0);
            }

            // 就要等到时间
            long targetTime = System.currentTimeMillis() + mill;
            long remaining = mill;
            while (this.pool.isEmpty() && remaining > 0) {
                this.pool.wait(remaining);
                remaining = targetTime - System.currentTimeMillis();
            }

            if (this.pool.isEmpty()) {
                return null;
            }

            return this.pool.get(0);
        }
    }
}
