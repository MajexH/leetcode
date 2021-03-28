package meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculateXor {

    private static List<Integer> nums = new ArrayList<Integer>() {{
        addAll(Arrays.asList(0, 0, 1, 3, 2, 4, 6, 1));
    }};

    // 暴力解法超时 只能找规律做
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] an = new int[n];

        for (int i = 0; i < n; i++) {
            an[i] = sc.nextInt();
        }

        // 其实是有规律的 如果保存之前的矩阵亦或结果即可
        int res = 0;

        for (int i = 0; i < n; i++) {
            res ^= an[i];
        }

        if (n >= nums.size()) {
            for (int i = nums.size(); i <= n; i++) {
                int tmp = 0;
                for (int j = 1; j < i; j++) {
                    tmp ^= j;
                }
                for (int j = 2; j < i; j++) {
                    tmp ^= (i % j);
                }
                nums.add(nums.get(i - 1) ^ tmp);
            }
        }

        System.out.println(res ^ nums.get(n));
    }
}
