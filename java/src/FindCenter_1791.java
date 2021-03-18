import java.util.HashSet;
import java.util.Set;

public class FindCenter_1791 {

    // 找到星型图的中心节点 其中心是有 n - 1 条边与其相连的
    public int findCenter(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }

        // 图中节点 编号从 1 - n
        Set<Integer>[] counts = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            counts[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            counts[edge[0]].add(edge[1]);
            counts[edge[1]].add(edge[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (counts[i].size() == n - 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindCenter_1791().findCenter(new int[][]{
                {1,2},{2,3},{4,2}
        }));
        System.out.println(new FindCenter_1791().findCenter(new int[][]{
                {1,2},{5,1},{1,3},{1,4}
        }));
    }
}
