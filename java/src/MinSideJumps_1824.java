import java.util.Deque;
import java.util.LinkedList;

public class MinSideJumps_1824 {

    public static class Node {
        int x, y;
        int jump;

        public Node(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }
    }

    public static int[][] nextYs = new int[][]{{1, 2}, {-1, 1}, {-1, -2}};

    // bfs
    // 从 0 2 出发 问能不能跳到 n 0 只有横向跳跃会加1
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        Deque<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 2, 0));
        // 保存已经访问过的节点 访问过则不再访问 因为是 bfs 的 所以一定在遍历的时候后续到达的节点比之前达到的节点的 jump 大
        boolean[][] visited = new boolean[n + 1][4];
        while (queue.size() > 0) {
            Node top = queue.removeFirst();

            visited[top.x][top.y] = true;
            if (top.x == n) return top.jump;
            int nextX = top.x + 1;
            int nextY = top.y;
            if (obstacles[nextX] != nextY) {
                if (!visited[nextX][nextY]) {
                    queue.add(new Node(nextX, nextY, top.jump));
                    visited[nextX][nextY] = true;
                }
                continue;
            }
            // 说明不能直接从当前这个位置跳过去 要从左右跳过去
            for (int bias : nextYs[top.y - 1]) {
                int curY = top.y + bias;
                if (obstacles[top.x] == curY || visited[top.x][curY]) continue;
                queue.add(new Node(top.x, curY, top.jump + 1));
                visited[top.x][curY] = true;
            }
        }
        // 不能到达
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinSideJumps_1824().minSideJumps(new int[]{0, 2, 1, 0, 3, 0}));
    }
}
