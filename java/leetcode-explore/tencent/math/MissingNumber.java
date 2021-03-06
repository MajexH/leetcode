package tencent.math;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int sum = Arrays.stream(nums).boxed().reduce(Integer::sum).get();
        int n = nums.length;
        return (n + 1) * n / 2 - sum;
    }
}
