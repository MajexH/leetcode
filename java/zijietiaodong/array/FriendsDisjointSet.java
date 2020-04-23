package array;

import java.util.Arrays;

public class FriendsDisjointSet {

    public int find(int[] parents, int i) {
        if (parents[i] == -1) {
            return i;
        }
        return find(parents, parents[i]);
    }

    // 求并查集
    public void union(int[] parents, int i, int j) {
        // 去寻找并查集上的i的最上层的父节点 也就是根节点
        int iFather = find(parents, i);
        int jFather = find(parents, j);
        // 因为现在 M[i][j]等于1 说明 i j 是有关系的
        // 所以将他们连起来 在他们的根节点不是同一个的时候
        // 只需要将两个根节点关系起来
        if (iFather != jFather) {
            parents[iFather] = jFather;
        }
    }

    public int findCircleNum(int[][] M) {
        // 并查集 并查集 说的其实就是用parents[i] = j 表示 j是i的父节点
        int[] parents = new int[M.length];
        // 默认没有父节点 或者说 父节点就是自己
        Arrays.fill(parents, -1);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                // 因为自己是不能访问自己的
                // 所以这个地方 只需要将两个有联系的 以及其中间对象 联系起来即可
                if (M[i][j] == 1 && i != j) {
                    union(parents, i, j);
                }
            }
        }
        int res = 0;
        for (int num : parents) {
            if (num == -1) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FriendsDisjointSet().findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
    }
}
