import java.util.*;

public class MFirst {

//    public static class Pair {
//        public Integer i;
//        public Integer max;
//
//        @Override
//        public String toString() {
//            return "Pair{" +
//                    "i=" + i +
//                    ", max=" + max +
//                    '}';
//        }
//    }

    public static class Pair {
        public Integer index;
        public Integer credit;

        public Pair(int i, int i1) {
            this.index = i;
            this.credit = i1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();

        HashSet<Integer> res = new HashSet<>();
        int[][] credits = new int[n][m];
//        Pair[] maxs = new Pair[m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                credits[i][j] = scanner.nextInt();
//                if (maxs[j] == null || maxs[j].max < credits[i][j]) {
//                    Pair temp = new Pair();
//                    temp.i = i;
//                    temp.max = credits[i][j];
//                    maxs[j] = temp;
//                }
//            }
//        }
//        for (Pair temp : maxs) {
//            res.add(temp.i);
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                credits[i][j] = scanner.nextInt();
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.credit - a.credit);
        for (int j = 0; j < m; j++) {

            for (int i = 0; i < n; i++) {
                queue.add(new Pair(i, credits[i][j]));
            }
            if (queue.size() > 0) {
                int max = queue.peek().credit;
                Pair temp;
                while (queue.size() > 0 && (temp = queue.poll()).credit == max) {
                    res.add(temp.index);
                }
            }
            queue.clear();
        }
        System.out.println(res.size());
    }
}
