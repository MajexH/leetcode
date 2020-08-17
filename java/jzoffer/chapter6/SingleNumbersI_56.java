package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumbersI_56 {

    // 一个数组中 除了两个数出现了一次 其他数都出现了两次
    // 找到这两个数
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int oneIndex = 1;
        while ((res & 1) == 0) {
            oneIndex <<= 1;
            res >>>= 1;
        }

        int left = 0;
        int right = 0;

        for (int num : nums) {
            if ((num & oneIndex) != 0) {
                left ^= num;
            } else {
                right ^= num;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumbersI_56().singleNumbers(new int[]{1, 2, 5, 2})));
    }
}
