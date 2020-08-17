import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkDelayTime_Example_743 {

    // 邻接表表示的图
    public class DirectionMap {
        // List 邻接表表示的有向加权图
        public List<List<Node>> map;

        public DirectionMap(int n) {
            this.map = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                this.map.add(new ArrayList<>());
            }
        }

        public void addEdge(int start, int end, int weight) {
            List<Node> nodeList = this.map.get(start);
            nodeList.add(new Node(end, weight));
        }

        public List<Node> getEdges(int node) {
            return this.map.get(node);
        }

    }

    public class Node {
        public int index;
        // 表示上一个节点到下一个节点的长度
        public int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    // 从 k 发出一个信号，一直到最后一个节点收到信号
    // 问能够让所有的节点收到信号，要过多久
    // 实际上是一个单元最短路问题 只需要更新节点即可
    public int networkDelayTime(int[][] times, int N, int K) {
        DirectionMap map = new DirectionMap(N);
        for (int[] time : times) {
            map.addEdge(time[0] - 1, time[1] - 1, time[2]);
        }

        // 表示距离 表示 从 start - j 的距离
        int[] dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        // 是否访问过
        boolean[] visited = new boolean[N];
        dis[K - 1] = 0;

        // 访问剩下的节点
        for (int i = 1; i < N; i++) {

            int disMin = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 1; j <= N; j++) {
                if (!visited[j - 1] && dis[j - 1] < disMin) {
                    index = j - 1;
                    disMin = dis[j - 1];
                }
            }

            if (index == -1) continue;
            visited[index] = true;
            // 更新剩下的节点在 dis 数组里面的值
            for (Node node : map.getEdges(index)) {
                // 如果节点没访问过 而且 经过之前找到的最短的点的从start过来的长度 小于直接从start过来的长度 说明要更新
                if (!visited[node.index] && dis[index] + node.weight < dis[node.index]) {
                    dis[node.index] = dis[index] + node.weight;
                }
            }
        }
        int max = 0;
        for (int di : dis) {
            if (di == Integer.MAX_VALUE) return -1;
            max = Math.max(di, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime_Example_743().networkDelayTime(new int[][]{
                {2,1,1},
                {2,3,1,},
                {3,4,1}
        }, 4, 2));
    }
}
