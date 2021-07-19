import java.util.Arrays;

public class MaxFrequency_1838_New {

    // 滑动窗口
    public int maxFrequencyWithWindow(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;

        int l = 0, r = 0;
        // 窗口中的值 所以现在以 右端点为基准的话 只需要知道 里面所有的数字变成
        // nums[r] 是不是需要移动超过 k 次
        long window = 0L;
        while (r < nums.length) {
            window += nums[r];
            while (l <= r && (long) nums[r] * (r - l + 1) - window > k) {
                window -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public int maxFrequencyBruteForce(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFrequency = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmpK = k;
            int tmpRes = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (tmpK < nums[i] - nums[j]) break;
                tmpK -= (nums[i] - nums[j]);
                tmpRes++;
            }
            maxFrequency = Math.max(maxFrequency, tmpRes);
        }
        return maxFrequency;
    }

    public static void main(String[] args) {
        System.out.println(new MaxFrequency_1838_New().maxFrequencyWithWindow(new int[]{1, 2, 4}, 5));
        System.out.println(new MaxFrequency_1838_New().maxFrequencyWithWindow(new int[]{1, 4, 8, 13}, 5));
    }
}
