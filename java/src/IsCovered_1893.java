import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class IsCovered_1893 {

    // left 到 right 中是否所有的数字都被 区间覆盖
    // 就是合并区间
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));

        Deque<int[]> stack = new LinkedList<>();

        for (int[] range : ranges) {
            if (stack.isEmpty() || range[0] > stack.peekLast()[1] + 1) {
                stack.addLast(range);
                continue;
            }
            int[] pre = stack.removeLast();
            stack.add(new int[]{Math.min(range[0], pre[0]), Math.max(range[1], pre[1])});
        }

        for (int[] range : stack) {
            if (left >= range[0] && right <= range[1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsCovered_1893().isCovered(new int[][]{
                {1,2}, {3,4}, {5,6}
        }, 2, 5));
    }
}
