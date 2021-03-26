import java.util.Arrays;
import java.util.Collections;

public class MaximumSum_1186 {

    public int maximumSum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        // 保存删除一个的结果
        int[] deleteOne = new int[arr.length];

        dp[0] = arr[0];
        // 最小值到达 -10^ (4)
        deleteOne[0] = -100000;
        int res = Math.max(dp[0], deleteOne[0]);
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            // 要删除一个数的话 要么保留当前数 和 之前删除一个数形成的最大值比较 要么删除当前这个数 与之前保存的最大值比较
            deleteOne[i] = Math.max(deleteOne[i - 1] + arr[i], dp[i - 1]);
            res = Math.max(res, Math.max(dp[i], deleteOne[i]));
        }
        return res;
    }

    // 最大子序和的变种 如果中间可以删除一个数字 问能够形成的最大子序和为多少
    public int maximumSumWithTwoDirection(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        // 因此要删除一个的话 只需要遍历被删除的项即可，然后将以 arr[i] 结尾的左右的最大子序和累加起来即可
        int[] left = new int[arr.length + 1];
        int[] right = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            if (left[i] < 0) left[i + 1] = arr[i];
            else left[i + 1] = left[i] + arr[i];
        }

        for (int j = arr.length - 1; j >= 0; j--) {
            if (right[j + 1] < 0) right[j] = arr[j];
            else right[j] = right[j + 1] + arr[j];
        }

        int res = Math.max(left[arr.length], right[0]);
        // 遍历需要删除的负数点 因为只有负数才需要删除 删除后才可能达到需要的连续两个段的最大值
        for (int i = 0; i < arr.length; i++) {
            // 只有小于 0 才需要分隔
            if (arr[i] < 0) {
                // 注意的是需要分离开 i == 0 i == arr.length - 1 因为 默认是0 会影响 res 为负数的情况
                if (i == 0) {
                    res = Collections.max(Arrays.asList(right[i + 1], res));
                } else if (i == arr.length - 1) {
                    res = Collections.max(Arrays.asList(left[i], res));
                } else {
                    // 平时的话 去掉这个值 只需要在三部分中取较大值与 res 比较即可
                    res = Collections.max(Arrays.asList(left[i] + right[i + 1], left[i], right[i + 1], res));
                }
            }
        }
        // 没有小于 0 的话 说明全是正数
        // 返回和即可
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new MaximumSum_1186().maximumSum(new int[]{-28,-23,-16,15,18,23,26,23,-26,-25,-10,-1,-4,-7,12,5,-10,-13,-14,-13,-28,-5,-16,15,-2,7,20,13,22}));
//        System.out.println(new MaximumSum_1186().maximumSum(new int[]{1, -2, 0, 3}));
//        System.out.println(new MaximumSum_1186().maximumSum(new int[]{1, -2, -2, 3}));
        System.out.println(new MaximumSum_1186().maximumSum(new int[]{-50}));
//        System.out.println(new MaximumSum_1186().maximumSum(new int[]{-1, -1, -1, -1}));
    }
}
