package multiThread;

public class Main {


    public static void main(String[] args) {

    }

    private void testConnectionPool() {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.init(10);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {

            }).start();
        }

    }

}
