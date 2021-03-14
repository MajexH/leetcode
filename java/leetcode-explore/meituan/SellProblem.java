package meituan;

import java.util.Scanner;

public class SellProblem {

    private static void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();

        int e = sc.nextInt(), f = sc.nextInt(), g = sc.nextInt();

        // 这个是贪心 卖最贵的
        // efg 进行排序 同时排序 abc   因为 abc 都是 跟 d 进行组合的

        int[] counts = new int[]{a, b, c}, prices = new int[]{e, f, g};

        // 3 个数 选择 从大到小
        for (int i = 0; i < 3; i++) {
            int maxIndex = i;
            for (int j = i; j < 3; j++) {
                if (prices[j] > prices[maxIndex]) maxIndex = j;
            }
            swap(prices, i, maxIndex);
            swap(counts, i, maxIndex);
        }
        long res = 0;
        // 现在排完序了 遍历
        for (int i = 0; i < prices.length; i++) {
            if (d <= 0) break;
            int min = Math.min(d, counts[i]);
            res += ((long) min * prices[i]);
            d -= min;

        }
        System.out.println(res);
    }
}
