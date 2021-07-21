import java.util.Comparator;
import java.util.PriorityQueue;

public class EliminateMaximum_1921 {

    public static class Pair implements Comparable<Pair> {
        public int dist, speed;

        public Pair(int dist, int speed) {
            this.dist = dist;
            this.speed = speed;
        }

        @Override
        public int compareTo(Pair o) {
            if (speed == o.speed) return dist - o.dist;
            if (dist == o.dist) return o.speed - speed;
            int a = (int) Math.ceil(this.dist / (double) this.speed);
            int b = (int) Math.ceil(o.dist / (double) o.speed);
            if (a != b) return a - b;
            return dist - o.dist;
        }
    }

    // 就是根据到达城市的时间排序
    public int eliminateMaximumBruteForce(int[] dist, int[] speed) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < dist.length; i++) {
            pq.add(new Pair(dist[i], speed[i]));
        }
        int res = 0;
        while (!pq.isEmpty() && pq.peek().dist != 0) {
            pq.poll();
            res++;
            PriorityQueue<Pair> another = new PriorityQueue<>();
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                p.dist = Math.max(p.dist - p.speed, 0);
                another.add(p);
            }
            pq = another;
        }

        return res;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int i = 0; i < dist.length; i++) {
            pq.add((int) Math.ceil(dist[i] / (double) speed[i]));
        }
        // res 为已经走过的时间
        // 那么只要已经走过的时间 比这个点到达的时间小 就可以消灭怪兽
        int res = 0;
        while (!pq.isEmpty() && res < pq.peek()) {
            pq.poll();
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{3,5,4,4,9}, new int[]{1,3,1,1,2}));
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{4,2}, new int[]{5,1}));
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{4,2,3}, new int[]{2,1,1}));
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{3,5,7,4,5}, new int[]{2,3,6,3,2}));
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{4,8,6,8,2,7,4}, new int[]{1,3,3,1,10,1,1}));
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{1,3,4}, new int[]{1,1,1}));
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{1,1,2,3}, new int[]{1,1,1,1}));
        System.out.println(new EliminateMaximum_1921().eliminateMaximum(new int[]{3,2,4}, new int[]{5,3,2}));
    }
}
