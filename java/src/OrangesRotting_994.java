import java.util.Deque;
import java.util.LinkedList;

public class OrangesRotting_994 {

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int res = 0;
        Deque<Pair> rottedOrange = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottedOrange.add(new Pair(i, j));
                }
            }
        }

        rottedOrange.add(null);

        while (!rottedOrange.isEmpty()) {
            Pair top = rottedOrange.removeFirst();
            if (top == null) {
                if (rottedOrange.size() == 0) break;
                rottedOrange.add(null);
                res++;
                continue;
            }

            // 四个方向
            for (int[] direction : directions) {
                int newX = top.x + direction[0], newY = top.y + direction[1];
                if (newX >= grid.length || newX < 0 || newY >= grid[newX].length || newY < 0) continue;
                if (grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    rottedOrange.add(new Pair(newX, newY));
                }
            }
        }

        for (int[] line : grid) {
            for (int orange : line) {
                if (orange == 1) return -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OrangesRotting_994().orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));

        System.out.println(new OrangesRotting_994().orangesRotting(new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        }));

        System.out.println(new OrangesRotting_994().orangesRotting(new int[][]{
                {1},
                {2}
        }));
    }
}
