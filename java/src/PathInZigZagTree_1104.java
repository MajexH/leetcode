import java.util.LinkedList;
import java.util.List;

public class PathInZigZagTree_1104 {

    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        int level = getLevel(label);
        while (label != 1) {
            res.addFirst(label);
            label = getParent(label, level);
            level--;
        }
        res.addFirst(label);
        return res;
    }

    private int getLevel(int label) {
        int i = 0;
        while (Math.pow(2, i) - 1 < label){
            i++;
        }
        return i;
    }

    private int getParent(int label, int level) {
        double left;
        if ((level & 1) == 0) {
            // 偶数层次 从右向左
            left = Math.pow(2, level) - label;
            return (int) (Math.pow(2, level - 2) - 1 + Math.ceil(left / 2));
        }
        // 从左向右
        left = label - Math.pow(2, level - 1) + 1;
        return (int) (Math.pow(2, level - 1) - 1 - Math.ceil(left / 2) + 1);

    }

    public static void main(String[] args) {
        System.out.println(new PathInZigZagTree_1104().pathInZigZagTree(14));
        System.out.println(new PathInZigZagTree_1104().pathInZigZagTree(26));
    }
}
