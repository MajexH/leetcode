import java.util.Scanner;

public class NeteaseSecond {

    public static class Node {
        int a, b, c, x, y, z;

        public boolean check() {
            return this.a % 2 == 0 &&
                    this.b % 2 == 0 &&
                    this.c % 2 == 0 &&
                    this.x % 2 == 0 &&
                    this.y % 2 == 0 &&
                    this.z % 2 == 0;
        }
    }

    public static boolean checkTwoNode(Node node1, Node node2) {
        return (node1.a - node2.a) % 2 == 0 &&
                (node1.b - node2.b) % 2 == 0 &&
                (node1.c - node2.c) % 2 == 0 &&
                (node1.x - node2.x) % 2 == 0 &&
                (node1.y - node2.y) % 2 == 0 &&
                (node1.z - node2.z) % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int maxLength = 0;
        // nodes i 表示 从  0 - i 的字符串里面  abc xyz 有多少个
        Node[] nodes = new Node[str.length()];
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
            nodes[i] = new Node();
            nodes[i].a = counts['a' - 'a'];
            nodes[i].b = counts['b' - 'a'];
            nodes[i].c = counts['c' - 'a'];
            nodes[i].x = counts['x' - 'a'];
            nodes[i].y = counts['y' - 'a'];
            nodes[i].z = counts['z' - 'a'];
            if (nodes[i].check()) {
                maxLength = Math.max(maxLength, i + 1);
            }
        }

        // 遍历 j - i 的子串
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (checkTwoNode(nodes[i], nodes[j])) {
                    maxLength = Math.max(maxLength, i - j);
                }
            }
        }

        System.out.println(maxLength);
    }
}
