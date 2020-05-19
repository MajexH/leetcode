import java.util.*;

public class MFirst {

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
