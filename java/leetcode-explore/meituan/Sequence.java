package meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sequence {

    public static void main(String[] args) {
        // 给定一个序列 如果其值为 [1, n] 表示其为正则序列
        // 问现在每次只能改变一个数字 +1 or -1 最少要操作多少次

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        int res = 0;
        // 让离得近的变化即可

        boolean[] hasNum = new boolean[n];
        List<Integer> sortNum = new ArrayList<>(n);
        for (int num : nums) {
            if (num >= 1 && num <= n && !hasNum[num - 1]) {
                hasNum[num - 1] = true;
            } else {
                sortNum.add(num);
            }
        }

        // 排序
        Collections.sort(sortNum);

        for (int i = 0, j = 0; i < n; i++) {
            if (!hasNum[i]) {
                int num = sortNum.get(j);
                if (i + 1 > num) {
                    res += i + 1 - num;
                } else {
                    res += num - i - 1;
                }
                j++;
            }
        }
        System.out.println(res);
    }
}
