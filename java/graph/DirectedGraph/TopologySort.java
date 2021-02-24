package DirectedGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TopologySort {
    // 拓扑排序必须是无环图 因此最开始要检测图成环

    // 1. dfs 的逆后续排列
    public static List<Integer> topologySortWithRecursion(DirectedGraph g) {
        // 作为一个栈
        List<Integer> stack = new ArrayList<>();
        boolean[] memo = new boolean[g.getCapacity()];
        for (int i = 0; i < g.getCapacity(); i++) {
            if (!memo[i]) {
                // 根据一个出发点 找到其 拓扑排序
                topologySortRecursion(g, stack, i, memo);
            }
        }

        List<Integer> res = new ArrayList<>();
        // 输出 stack
        for (int i = stack.size() - 1; i >= 0; i--) {
            res.add(stack.get(i));
        }
        return res;
    }

    private static void topologySortRecursion(DirectedGraph g, List<Integer> res, int start, boolean[] memo) {
        memo[start] = true;
        for (int adj : g.adj(start)) {
            if (!memo[adj]) {
                topologySortRecursion(g, res, adj, memo);
            }
        }
        res.add(start);
    }

    // 2. 不停地遍历入度为 0 的点 然后删除
    public static List<Integer> topologySortIteration(DirectedGraph g) {

        int[] inDegree = new int[g.getCapacity()];

        for (int i = 0; i < g.getCapacity(); i++) {
            for (int adj : g.adj(i)) {
                inDegree[adj] += 1;
            }
        }

        Deque<Integer> inDegreeEqualsZero = new LinkedList<>();

        // 找到为 0 的点
        for (int i = 0; i < g.getCapacity(); i++) {
            if (inDegree[i] == 0) {
                inDegreeEqualsZero.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!inDegreeEqualsZero.isEmpty()) {
            int top = inDegreeEqualsZero.poll();
            res.add(top);
            for (int adj : g.adj(top)) {
                inDegree[adj] -= 1;
                if (inDegree[adj] == 0) {
                    inDegreeEqualsZero.offer(adj);
                }
            }
        }

        return res;

    }


    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(9);
        g.addEdge(1, 0);
        g.addEdge(3, 4);
        g.addEdge(2, 6);
        g.addEdge(8, 3);
        g.addEdge(5, 1);
        g.addEdge(1, 7);

        System.out.println(topologySortWithRecursion(g));
        System.out.println(topologySortIteration(g));
    }
}
