public class Union {
    // 并查集
    int[] parents;

    public Union(int capacity) {
        this.parents = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            // 初始化
            this.parents[i] = i;
        }
    }

    public void union(int n1, int n2) {
        int rootOfN1 = find(n1);
        int rootOfN2 = find(n2);

        if (rootOfN1 == rootOfN2) return;
        // n1 root 连接到 n2 root 上
        this.parents[rootOfN1] = rootOfN2;
    }

    // 找到跟节点
    private int find(int node) {
        if (this.parents[node] == node) {
            return node;
        }
        return find(this.parents[node]);
    }

    public boolean connected(int i, int j) {
        // 判断两个 root 是否相等
        int rootOfI = find(i);
        int rootOfJ = find(j);

        return rootOfI == rootOfJ;
    }
}
