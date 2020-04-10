import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MaxCost {

    class Node {
        public int id;
        public int pId;
        public int cost;

        public boolean isLeaf = true;

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", pId=" + pId +
                    ", cost=" + cost +
                    ", isLeaf=" + isLeaf +
                    '}';
        }
    }

    /**
     * 大致意思是给定一组树节点，形式为（id, pId, cost），其中id是节点的序号，pId是父节点的序号，cost是花费，
     * 即完成这件事情所需的花费。给定的节点可以构成一棵树或者一个森林，需要求出树或森林中最大的花费是多少。举例如下：
     * 给定节点：
     * 1, 0, 2
     * 2, 1, 3
     * 3, 1, 2
     * 4, 0, 3
     * 构成如下森林：
     *
     *                 (1, 0, 2)               (4, 0, 3)
     *                _____|_____
     *               |           |
     *          (2, 1, 3)     (3, 1, 2)
     *
     * 耗费最大的肯定在叶节点，id=2的节点总花费为父节点2+本身花费3=5，以此类推，id=3的节点花费为4，id=4的节点花费为3，所以给定这组节点花费的最大花费是5。
     * @return
     */
    public int getMaxCost() {
        HashMap<Integer, Node> nodes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        // 代表节点数
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Node tempNode = new Node();
            String[] tempStr = scanner.next().split(",");
            tempNode.id = Integer.parseInt(tempStr[0]);
            tempNode.pId = Integer.parseInt(tempStr[1]);
            tempNode.cost = Integer.parseInt(tempStr[2]);
            nodes.put(tempNode.id, tempNode);
        }
        // 设置isLeaf
        for (Node temp : nodes.values()) {
            if (nodes.containsKey(temp.pId)) {
                nodes.get(temp.pId).isLeaf = false;
                temp.cost = nodes.get(temp.pId).cost + temp.cost;
            }

        }
        System.out.println(nodes);
        int max = 0;
        // 拿到最大的值
        for (Node temp : nodes.values()) {
            if (temp.isLeaf) max = Math.max(max, temp.cost);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxCost().getMaxCost());
    }
}
