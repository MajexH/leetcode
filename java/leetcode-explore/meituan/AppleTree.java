package meituan;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AppleTree {

    private static class Pair implements Comparable<Pair> {
        int color;
        int count;

        public Pair(int color, int count) {
            this.color = color;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            // 按照 count 进行大顶堆排序 如果count相等 按照color 顺序来
            if (count == o.count) return color - o.color;
            return o.count - count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] tmp = reader.readLine().split(" ");
            // 转为 0 开始
            int from = Integer.parseInt(tmp[0]) - 1, to = Integer.parseInt(tmp[1]) - 1;
            map.get(from).add(to);
        }
        // 表示空格
        String[] ints = reader.readLine().split(" ");
        // 保存节点的颜色
        int[] colors = new int[n];
        for (int i = 0; i < ints.length; i++) {
            colors[i] = Integer.parseInt(ints[i]);
        }

        // dfs 处理得到每个节点向下的结果
        // 1 号节点为跟 所以从 1 号开始
        // 因为是树 不会成环 所以不用 memo

        // 存储每个节点下对应的 color 的数量
        Map<Integer, PriorityQueue<Pair>> res = new HashMap<>();

        dfs(map, 0, colors, res);

        int q = Integer.parseInt(reader.readLine());
        for (; q > 0; q--) {
            int node = Integer.parseInt(reader.readLine());
            PriorityQueue<Pair> c = res.get(node - 1);
            if (c == null || c.peek() == null) continue;
            writer.write(String.valueOf(c.peek().color));
            writer.newLine();
        }
        writer.flush();
    }

    // 针对每个节点进行存储
    // 后续遍历 返回 当前节点的颜色在两个map中得到
    private static Map<Integer, Integer> dfs(List<List<Integer>> map, int start, int[] colors, Map<Integer, PriorityQueue<Pair>> res) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (Integer adj : map.get(start)) {
            Map<Integer, Integer> child = dfs(map, adj, colors, res);
            for (int key : child.keySet()) {
                tmp.put(key, tmp.getOrDefault(key, 0) + child.get(key));
            }
        }
        // 存储如跟节点的
        tmp.put(colors[start], tmp.getOrDefault(colors[start], 0) + 1);
        PriorityQueue<Pair> add = new PriorityQueue<>();
        for (int key : tmp.keySet()) {
            add.add(new Pair(key, tmp.get(key)));
        }
        // 保存当前节点的状态
        res.put(start, add);

        return tmp;
    }
}
