package highFrequency.divide;

import java.util.Arrays;

public class KClosestNew {

    // 快排 partition
    public int[][] kClosest(int[][] points, int K) {
        int i = 0, j = points.length - 1;
        int index = partition(points, i, j);
        while (index != K - 1) {
            if (index > K - 1) {
                j = index - 1;
            } else {
                i = index + 1;
            }
            index = partition(points, i, j);
        }
        return Arrays.copyOf(points, K);
    }

    public int partition(int[][] points, int start, int end) {
        int[] base = points[start];
        int i = start, j = end + 1;

        while (true) {
            i++;
            // 找到第 k 小
            while (i <= end && cmp(points[i], base) < 0) {
                i++;
            }
            j--;
            while (j >= start && cmp(points[j], base) > 0) {
                j--;
            }
            if (i >= j) break;
            swap(points, i, j);
        }
        swap(points, start, j);
        return j;
    }

    public void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public int cmp(int[] n1, int[] n2) {
        return n1[0] * n1[0] + n1[1] * n1[1] - (n2[0] * n2[0] + n2[1] * n2[1]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KClosestNew().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
