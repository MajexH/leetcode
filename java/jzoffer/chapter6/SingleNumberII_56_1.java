package chapter6;

import java.util.Arrays;

public class SingleNumberII_56_1 {

    // 一个数组中 有一个数 出现了一次 其他数 都出现了三次 找出这个数
    public int singleNumber(int[] nums) {
        // 统计 nums 中每个 int 中每一位上的 1 的数量 然后 模 3 就可以得到这个单个数在每一位上的1的数量 这个数就出来了
        int[] res = new int[32];
        for (int num : nums) {
            for (int i = 31, j = 1; i >= 0; i--) {
                if ((num & j) != 0) {
                    res[i]++;
                    res[i] %= 3;
                }
                j <<= 1;
            }
        }
        int number = 0;
        for (int i = 0; i < 32; i++) {
            number <<= 1;
            number += res[i];
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII_56_1().singleNumber(new int[]{1,3,3,3}));
    }
}
