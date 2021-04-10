import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumHammingDistance_1722 {

    public void union(int[] union, int i, int j) {
        int x = getParent(union, i);
        int y = getParent(union, j);
        if (x != y) {
            union[y] = x;
        }
    }

    public int getParent(int[] union, int i) {
        if (union[i] == -1) return i;
        return getParent(union, union[i]);
    }

    public void changeUnion(int[] union) {
        boolean[] memo = new boolean[union.length];

        for (int i = 0; i < union.length; i++) {
            if (!memo[i]) {
                recursion(union, memo, i);
            }
        }
    }

    // 更该 union 到root
    public int recursion(int[] union, boolean[] memo, int i) {
        if (memo[i]) return union[i];
        memo[i] = true;
        if (union[i] == -1 || union[i] == i) {
            union[i] = i;
            return i;
        }
        int root = recursion(union, memo, union[i]);
        union[i] = root;
        return root;
    }

    // 连通图问题 在连通分量里面找到不等的数字
    // 无向图的连通分量
    // 可以使用 dfs 得到无向图的连通分量 or 使用 union 的算法得到连通分量
    // 但是 union 算法如果直接在算法执行图中去更改所有的 root 值 会慢一点儿 所以在执行完毕后去更改
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int[] union = new int[source.length];
        Arrays.fill(union, -1);

        for (int[] allowSwap : allowedSwaps) {
            union(union, allowSwap[0], allowSwap[1]);
        }

        // 修改连通分量标识 到根节点
        changeUnion(union);
        // 现在每个中对应的都是一个连通分量的根节点的下标，那么就需要知道 一个连通分量里面有多少个不等的

        // 保存root中的数字每个出现了几次
        Map<Integer, Map<Integer, Integer>> sMap = new HashMap<>();
        for (int i = 0; i < union.length; i++) {
            int root = union[i];
            if (!sMap.containsKey(root)) sMap.put(root, new HashMap<>());
            Map<Integer, Integer> tmp = sMap.get(root);
            tmp.put(source[i], tmp.getOrDefault(source[i], 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < union.length; i++) {
            int root = union[i];
            Map<Integer, Integer> tmp = sMap.get(root);
            if (!tmp.containsKey(target[i]) || tmp.get(target[i]) == 0) {
                res++;
            } else {
                tmp.put(target[i], tmp.get(target[i]) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumHammingDistance_1722().minimumHammingDistance(new int[]{49, 21, 79, 79, 6, 67, 78, 9, 91, 39, 49, 32, 53, 29, 97, 50, 82, 55, 13, 83, 63, 99, 41, 6, 51, 46, 31, 26, 58, 18, 32, 51, 44, 66, 40, 35, 96, 20, 35, 43, 64, 96, 99, 76, 11, 35, 86, 96, 10, 19, 70, 29, 19, 47}, new int[]{33, 22, 32, 71, 66, 90, 78, 67, 74, 76, 84, 32, 25, 100, 57, 7, 90, 95, 33, 79, 54, 99, 42, 6, 32, 55, 31, 14, 58, 67, 48, 59, 7, 50, 5, 22, 11, 97, 94, 14, 53, 75, 3, 9, 82, 74, 86, 27, 21, 77, 70, 29, 65, 15}, new int[][]{{40, 41}, {41, 35}, {18, 19}, {9, 51}, {48, 2}, {45, 13}, {27, 45}, {16, 22}, {23, 25}, {2, 6}, {5, 11}, {37, 38}, {22, 48}, {13, 48}, {51, 37}, {24, 19}, {2, 32}, {38, 23}, {33, 34}, {37, 44}, {31, 8}, {4, 26}, {34, 35}, {37, 28}, {48, 34}, {27, 0}, {23, 37}, {17, 29}, {38, 7}, {37, 31}, {34, 42}, {26, 20}, {22, 45}, {26, 29}, {40, 42}, {48, 30}, {46, 49}, {12, 52}, {49, 28}, {39, 14}, {23, 34}, {6, 30}, {18, 12}, {52, 49}, {21, 18}, {11, 4}, {2, 7}, {4, 17}, {19, 27}, {33, 5}, {44, 28}, {38, 9}, {34, 7}, {7, 47}, {37, 13}, {51, 12}, {42, 53}, {42, 21}, {18, 9}, {21, 39}, {4, 33}, {29, 39}, {47, 41}, {25, 13}, {50, 0}, {21, 48}, {32, 27}, {33, 53}, {39, 5}, {12, 25}, {52, 6}, {17, 44}, {16, 52}, {0, 34}, {14, 29}, {0, 19}, {13, 7}, {29, 21}, {9, 22}, {28, 45}, {1, 29}, {37, 17}, {38, 36}, {4, 23}, {38, 21}, {35, 5}, {2, 16}, {34, 30}, {37, 16}, {40, 53}, {51, 47}, {20, 32}, {7, 9}, {12, 15}, {26, 0}, {14, 44}, {53, 11}, {48, 17}}));
    }
}
