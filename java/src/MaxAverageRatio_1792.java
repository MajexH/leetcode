import java.util.PriorityQueue;

public class MaxAverageRatio_1792 {

    private static class Pair implements Comparable<Pair> {
        int pass, total;

        public Pair(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        public void addOne() {
            this.pass += 1;
            this.total += 1;
        }

        private double getAverage() {
            return (double) pass / total;
        }

        // 比较的是 如果加上 1 的之后 其增长率贡献最大的点
        // 将其作为大顶堆 每次从大顶堆里面出来的数 都会是对增长率贡献最大的点
        @Override
        public int compareTo(Pair o) {
            double cur = (double) (pass + 1) / (total + 1) - (double) pass / total;
            double other = (double) (o.pass + 1) / (o.total + 1) - (double) o.pass / o.total;
            return Double.compare(other, cur);
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int[] classy : classes) {
            pq.add(new Pair(classy[0], classy[1]));
        }

        while (extraStudents > 0) {
            Pair min = pq.poll();
            assert min != null;
            min.addOne();
            pq.add(min);
            extraStudents--;
        }
        // 计算平均通过率
        double res = 0;

        for (Pair p : pq) {
            res += p.getAverage();
        }

        return res / pq.size();
    }

    public static void main(String[] args) {
        System.out.println(new MaxAverageRatio_1792().maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
        System.out.println(new MaxAverageRatio_1792().maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4));
    }
}
