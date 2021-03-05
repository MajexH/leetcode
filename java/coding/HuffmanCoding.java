import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    // huffman 编码是一种压缩比特的方法
    // 使用一个字符串树来表示原始的数据
    // 在序列化原始数据的时候 会同时加入该压缩树
    // 以方便解码


    private static class Node implements Comparable<Node> {

        Node left, right;
        char c;
        int frequency;

        public Node(Node left, Node right, char c, int frequency) {
            this.left = left;
            this.right = right;
            this.c = c;
            this.frequency = frequency;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        @Override
        public int compareTo(Node o) {
            return this.frequency - o.frequency;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", c=" + c +
                    ", frequency=" + frequency +
                    '}';
        }
    }

    // 压缩操作
    // 使用 PriorityQueue
    public Node buildNode(String s) {
        // 1. 第一遍遍历先得到 frequency
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 2. 根据频率构建森林
        for (char c : map.keySet()) {
            pq.add(new Node(null, null, c, map.get(c)));
        }

        // 3. 构建树
        while (pq.size() > 1) {
            Node x = pq.poll(), y = pq.poll();
            pq.add(new Node(x, y, '\0', x.frequency + y.frequency));
        }
        // 最后剩下的节点就是根节点
        return pq.poll();
    }

    // 将传入的字符串 按照 node 树的走向编译成 01 序列
    public String compress(Node tree, String s) {
        // 1. 构建 tree
        Map<Character, String> map = new HashMap<>();
        // 2. 构建 binary map
        getBinary(tree, map, "");
        // 3. 根据 map 得到 String
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            res.append(map.get(c));
        }
        return res.toString();
    }
    // 根据 character 得到对应 build 的 binary
    private void getBinary(Node tree, Map<Character, String> map, String tmp) {
        if (tree.isLeaf()) {
            map.put(tree.c, tmp);
            return;
        }
        getBinary(tree.left, map, tmp + "0");
        getBinary(tree.right, map, tmp + "1");
    }

    // 根据传入的对应的符号表 + 二进制数组 进行解码
    public String expand(String binary, Node node) {
        // 根据输入的 binary 和 root 的map 还原原始的字符串
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < binary.length();) {
            Node mv = node;
            while (!mv.isLeaf()) {
                if (binary.charAt(i) == '0') {
                    // 左拐
                    mv = mv.left;
                } else {
                    mv = mv.right;
                }
                i++;
                if (i >= binary.length()) break;
            }
            builder.append(mv.c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        HuffmanCoding h = new HuffmanCoding();
        Node a = h.buildNode("it was the best of times it was the worst of times");
        String binary = h.compress(a, "it was the best of times it was the worst of times");
        System.out.println(h.expand(binary, a));
    }


}
