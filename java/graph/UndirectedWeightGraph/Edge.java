package UndirectedWeightGraph;

public class Edge implements Comparable<Edge> {
    public int from;
    public int to;
    public int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    // 根据传入的值 返回不同的 from to
    public int other(int in) {
        // 根据传入的端点 找到链接的另外一个断点
        if (in == from) {
            return to;
        }
        return from;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}
