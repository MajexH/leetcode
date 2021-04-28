import java.util.*;

public class GetOrder_1834 {

    private static class Task {
        int enqueueTime, processTime;
        int index;

        public Task(int enqueueTime, int processTime, int index) {
            this.enqueueTime = enqueueTime;
            this.processTime = processTime;
            this.index = index;
        }

    }

    public int[] getOrder(int[][] tasks) {
        List<Integer> res = new ArrayList<>();
        // 两个队列 一个队列是用来保存任务的 一个是入队的队列
        PriorityQueue<Task> enqueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.enqueueTime));
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.processTime == b.processTime) {
                return a.index - b.index;
            }
            return a.processTime - b.processTime;
        });

        for (int i = 0; i < tasks.length; i++) {
            enqueue.add(new Task(tasks[i][0], tasks[i][1], i));
        }

        if (enqueue.size() == 0) return new int[]{};

        // 开始的时间 现在吧等于开始时间的全部加入到 pq 中
        int curTime = enqueue.peek().enqueueTime;

        while (!enqueue.isEmpty()) {
            // 先倒腾到 pq 中
            while (!enqueue.isEmpty() && enqueue.peek().enqueueTime <= curTime) {
                pq.add(enqueue.poll());
            }
            // 出 pq 更新时间
            // 如果出队的后更新的 curTime 比 enqueue 的 peek 小 更新到 enqueue.peek 的时间即可
            while (!pq.isEmpty()) {
                Task poll = pq.poll();
                curTime += poll.processTime;
                res.add(poll.index);
                // curTime 有可能已经大于了 enqueue 的时间
                while (!enqueue.isEmpty() && enqueue.peek().enqueueTime <= curTime) {
                    pq.add(enqueue.poll());
                }
            }
            if (!enqueue.isEmpty()) {
                curTime = Math.max(curTime, enqueue.peek().enqueueTime);
            }
        }

        int[] returnVal = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            returnVal[i] = res.get(i);
        }

        return returnVal;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetOrder_1834().getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
        System.out.println(Arrays.toString(new GetOrder_1834().getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));
    }
}
