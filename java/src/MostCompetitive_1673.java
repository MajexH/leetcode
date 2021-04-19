import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MostCompetitive_1673 {

    public int[] mostCompetitive(int[] nums, int k) {
        if (k > nums.length) return new int[k];
        if (k == nums.length) return nums;

        int[] res = new int[k];
        // 单调栈
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 如果当前数字比 stack 里面的要小 说明概要弹出
            // 或者num 后剩下的长度不够了就不能弹出了
            while (!stack.isEmpty() && stack.peekLast() > num && k - stack.size() < nums.length - i) {
                stack.removeLast();
            }

            if (stack.size() < k) {
                stack.addLast(num);
            }
        }

        k--;
        while (k >= 0) {
            res[k] = stack.removeLast();
            k--;
        }
        return res;
    }

    // 同一个位置上的数字更小的 int[] 更具竞争力
    // 问长度为 k 的 int[] 的最有竞争力的结果是什么
    // 找到最小的 看后面的数 是否满足剩下的大小 不然就往前找 找到剩下的最小的
    public int[] mostCompetitiveBruteForce(int[] nums, int k) {
        if (k > nums.length) return new int[k];
        if (k == nums.length) return nums;

        int[] res = new int[k];

        recursion(nums, res, 0, nums.length - 1, 0, res.length - 1);
        return res;
    }

    // 直接使用递归 每次找到 i->j 的最小值 然后判断去什么其他地方填充即可
    public void recursion(int[] nums, int[] res, int i, int j, int n, int m) {
        if (n > m) return;
        int min = i;
        for (int k = i; k <= j; k++) {
            if (nums[k] < nums[min]) min = k;
        }
        // 剩下的数字不足以填满 m
        if (j - min + 1 <= m - n + 1) {
            for (int k = j; k >= min; k--) {
                res[m--] = nums[k];
            }
            recursion(nums, res, i, min - 1, n, m);
            return;
        }
        // 还足够填满 从剩下的里面取较小的数字 然后填满
        res[n++] = nums[min];
        recursion(nums, res, min + 1, j, n, m);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MostCompetitive_1673().mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3)));
        System.out.println(Arrays.toString(new MostCompetitive_1673().mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(new MostCompetitive_1673().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
    }
}
