package highFrequency.divide;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest {

    /**
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
     *
     * （这里，平面上两点之间的距离是欧几里德距离。）
     *
     * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((array2, array1) -> array1[0] * array1[0] + array1[1] * array1[1] - (array2[0] * array2[0] + array2[1] * array2[1]));
        for (int[] array : points) {
            queue.add(array);
            if (queue.size() > K) queue.poll();
        }
        int[][] res = new int[queue.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KClosest().kClosest(new int[][]{
                {3, 3}, {5, -1},{-2,4}
        }, 2)));
    }
}
