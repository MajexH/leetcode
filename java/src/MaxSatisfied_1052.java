import java.util.ArrayList;

public class MaxSatisfied_1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 分两步计算 一个计算满足要求的所有和 total 另一个窗口可以额外增加的值
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            // grumpy[i] == 0 的时候 才加上
            total += (1 - grumpy[i]) * customers[i];
        }
        // 遍历可以增加的值 找到最大的
        int window = 0;
        // 窗口遍历可以增加的值
        for (int i = 0; i < X; i++) {
            // 窗口可以增加的值 是 grumpy[i] == 1
            window += grumpy[i] * customers[i];
        }
        int res = window;
        for (int i = X; i < customers.length; i++) {
            window = window - grumpy[i-X] * customers[i-X] + grumpy[i] * customers[i];
            res = Math.max(res, window);
        }
        return total + res;
    }

    // 使用一个 sum
    public int maxSatisfiedWithSumArray(int[] customers, int[] grumpy, int X) {
        // sum[i] 保存 customers[i] 之前的所有满足要求的和
        int[] sum = new int[customers.length + 1];

        for (int i = 1; i <= customers.length; i++) {
            sum[i] = sum[i - 1];
            if (grumpy[i - 1] == 0) {
                sum[i] += customers[i - 1];
            }
        }
        // 结果
        int res = 0;
        // 维护一个窗口 这个窗口长度为 X 全部认为是可以加的
        int windowSum = 0;
        for (int i = 0; i < X; i++) {
            windowSum += customers[i];
        }
        for (int i = X; i < customers.length; i++) {
            res = Math.max(res, sum[i-X] + windowSum + sum[customers.length] - sum[i]);
            windowSum = windowSum - customers[i - X] + customers[i];
        }
        res = Math.max(res, sum[customers.length-X] + windowSum);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSatisfied_1052().maxSatisfied(new int[]{4,10,10}, new int[]{1,1,0}, 2));
        System.out.println(new MaxSatisfied_1052().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
