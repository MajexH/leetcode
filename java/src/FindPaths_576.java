import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindPaths_576 {

    private final static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i && j == node.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // node -- 对上当前这个节点被访问了多少次
        Map<Node, BigInteger> map = new HashMap<>();
        map.put(new Node(startRow, startColumn), new BigInteger("1"));
        BigInteger res = new BigInteger("0");

        for (int i = 0; i < maxMove; i++) {
            Map<Node, BigInteger> tmp = new HashMap<>();
            for (Map.Entry<Node, BigInteger> pair : map.entrySet()) {
                for (int[] direction : directions) {
                    Node node = pair.getKey();
                    int x = node.i + direction[0], y = node.j + direction[1];
                    // 那么 越界的时候 实际上 node 对应的次数 都会越界
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        // 越界了
                        res = res.add(pair.getValue());
                    } else {
                        // 新的节点 则需要加上之前的路径数量
                        tmp.put(new Node(x, y), tmp.getOrDefault(new Node(x, y), new BigInteger("0")).add(pair.getValue()));
                    }
                }
            }
            map = tmp;
        }

        return res.mod(new BigInteger("1000000007")).intValue();
    }

    private static long res = 0L;

    // dfs 找的超时了
    public int findPathsWithDFS(int m, int n, int maxMove, int startRow, int startColumn) {
        res = 0L;
        recursion(m, n, startRow, startColumn, maxMove);
        return (int) res;
    }

    public void recursion(int m, int n, int i, int j, int maxMove) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            res = (res + 1) % 1000000007;
            return;
        }
        if (maxMove == 0) return;

        recursion(m, n, i + 1, j, maxMove - 1);
        recursion(m, n, i - 1, j, maxMove - 1);
        recursion(m, n, i, j - 1, maxMove - 1);
        recursion(m, n, i, j + 1, maxMove - 1);
    }

    public static void main(String[] args) {
        System.out.println(new FindPaths_576().findPaths(36, 5, 50, 15, 3));
        System.out.println(new FindPaths_576().findPaths(8, 50, 23, 5, 26));
        System.out.println(new FindPaths_576().findPaths(2, 2, 2, 0, 0));
        System.out.println(new FindPaths_576().findPaths(1, 3, 3, 0, 1));
    }
}
