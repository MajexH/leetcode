package highFrequency.map;

import java.util.*;

public class CriticalConnections {

    public static class Edge {
        int from, to;

        // 给path排个序 就可以判断同一个 edge 了
        public Edge(int from, int to) {
            if (from < to) {
                from = from ^ to;
                to = from ^ to;
                from = from ^ to;
            }
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return from == edge.from && to == edge.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    int count = 0;
    // 寻找环形的强连通分量
    // 然后在环形圈 中找到与外界相连的边 加入
    // 我的方法有问题
    // 有问题的在于 ids 更新时 不好判断一个环里面 哪些该更新 哪些不该
    // Tarjan 算法 ！！！！
    public List<List<Integer>> criticalConnectionsWithProblem(int n, List<List<Integer>> connections) {
        count = 0;
        // 构建图
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (List<Integer> edges : connections) {
            map.get(edges.get(0)).add(edges.get(1));
            map.get(edges.get(1)).add(edges.get(0));
        }

        // 环形连通分量的标识
        int[] ids = new int[n];
        // -1 表示不与任何成环
        Arrays.fill(ids, -1);
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(map, new ArrayList<>(), i, marked, ids, -1);
            }
        }
        Set<Edge> set = new HashSet<>();
        // 只要 ids 不为 -1 的 都需要去遍历其边 找到与外界相连的边 都是关键连接
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == -1) continue;
            // 只要 adj 的 ids 与其不相同 说明其不再一个环上
            for (int adj : map.get(i)) {
                if (ids[adj] == ids[i]) continue;;
                // 不再一个环上 说明是关键的连接
                set.add(new Edge(i, adj));
            }
        }

        List<List<Integer>> res = new ArrayList<>(set.size());

        for (Edge e: set) {
            res.add(new ArrayList<>(){{
                add(e.from);
                add(e.to);
            }});
        }
        return res;
    }

    // 找环
    public void dfs(List<List<Integer>> map, List<Integer> path, int start, boolean[] marked, int[] ids, int pre) {
        marked[start] = true;
        path.add(start);
        for (int adj : map.get(start)) {
            // 因为是无向图 所以遍历的时候 还要注意的是 当前这个节点 不能是跟父节点同一个 不然是同一边访问了两次
            if (!marked[adj]) {
                dfs(map, path, adj, marked, ids, start);
            } else {
                if (pre == adj) continue;
                // 这儿赋值的时候 可能存在 0 -> 1 -> 3 -> 4 -> 5 ->3 这样的环 因此 去 path 里面遍历的时候 重复的节点后面的成环
                // 第二次访问的话 已经是成环了 设置 ids

                // 统计连通分量大小 因为只需要更新较小的连通分量

                if (ids[adj] != -1) {
                    int size = 0, circal = 0;
                    // 已经从属于一个连通分量
                    for (int id : ids) {
                        if (id == ids[adj]) {
                            size++;
                        }
                    }
                    boolean flag = false;
                    for (int index : path) {
                        if (index == adj) flag = true;
                        if (!flag) continue;
                        // 当前环的大小
                        circal++;
                    }
                    if (size >= circal) continue;
                }
                boolean flag = false;
                for (int index : path) {
                    if (index == adj) flag = true;
                    if (!flag) continue;
                    ids[index] = count;
                }
                // 找到了一个环
                count++;
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(){{
            add(0);
            add(1);
        }});
        res.add(new ArrayList<>(){{
            add(0);
            add(2);
        }});
        res.add(new ArrayList<>(){{
            add(2);
            add(3);
        }});
        res.add(new ArrayList<>(){{
            add(4);
            add(2);
        }});
        res.add(new ArrayList<>(){{
            add(3);
            add(4);
        }});
        res.add(new ArrayList<>(){{
            add(3);
            add(0);
        }});
        res.add(new ArrayList<>(){{
            add(4);
            add(0);
        }});

    }
}
