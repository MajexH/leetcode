//给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条
//长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。 
//
// 给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，你的任务是对于每个查询 queries[j] ，判断
//是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。 
//
// 请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 
//true 时， answer 第 j 个值为 true ，否则为 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0
//,2,5]]
//输出：[false,true]
//解释：上图为给定的输入数据。注意到 0 和 1 之间有两条重边，分别为 2 和 16 。
//对于第一个查询，0 和 1 之间没有小于 2 的边，所以我们返回 false 。
//对于第二个查询，有一条路径（0 -> 1 -> 2）两条边都小于 5 ，所以这个查询我们返回 true 。
// 
//
// 示例 2： 
// 
// 
//输入：n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],
//[1,4,13]]
//输出：[true,false]
//解释：上图为给定数据。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 1 <= edgeList.length, queries.length <= 10⁵ 
// edgeList[i].length == 3 
// queries[j].length == 3 
// 0 <= ui, vi, pj, qj <= n - 1 
// ui != vi 
// pj != qj 
// 1 <= disi, limitj <= 10⁹ 
// 两个点之间可能有 多条 边。 
// 
//
// Related Topics 并查集 图 数组 排序 👍 75 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class CheckingExistenceOfEdgeLengthLimitedPaths1697 {

    public static void main(String[] args) {
        Solution solution = new CheckingExistenceOfEdgeLengthLimitedPaths1697().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            // 边按照 weight 排序 保证每次查到的数据 weight 是递增的
            Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

            // 保存 queries 里面的原始顺序 最后来保存结果
            Integer[] indexes = new Integer[queries.length];
            for (int i = 0; i < queries.length; i++) {
                indexes[i] = i;
            }
            // 先将 queries 按照 limit 排序 直接排序下标
            Arrays.sort(indexes, Comparator.comparingInt(a -> queries[a][2]));

            UnionFind unionFind = new UnionFind(n);
            boolean[] res = new boolean[queries.length];

            int edgeIndex = 0;
            for (int i : indexes) {
                // 把小于 limit 的大小全部关联起来
                while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < queries[i][2]) {
                    unionFind.union(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                    edgeIndex++;
                }
                if (unionFind.connected(queries[i][0], queries[i][1])) {
                    res[i] = true;
                }
            }

            return res;
        }

        private static final class UnionFind {

            private int[] nodes;

            public UnionFind(int n) {
                this.nodes = new int[n];

                for (int i = 0; i < n; i++) {
                    this.nodes[i] = i;
                }
            }

            public void union(int x, int y) {
                int rootOfX = this.findRoot(x);
                int rootOfY = this.findRoot(y);

                if (x == y) {
                    return;
                }
                this.nodes[rootOfX] = rootOfY;
            }

            private int findRoot(int x) {
                if (this.nodes[x] == x) {
                    return x;
                }
                return this.findRoot(this.nodes[x]);
            }

            public boolean connected(int i, int j) {
                // 判断两个 root 是否相等
                int rootOfI = this.findRoot(i);
                int rootOfJ = this.findRoot(j);

                return rootOfI == rootOfJ;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}