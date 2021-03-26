package meituan;

import java.util.Scanner;

public class BuyDecorates {

    public static void main(String[] args) {
        // 选取连续的装饰物 并且装饰物的美丽值不能低于 k 那么有几种选择方案
        Scanner sc = new Scanner(System.in);
        // n 个装饰物 需要购买 m 个连续的 每个的值不小于 k 问有几种
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] decorates = new int[n];

        for (int i = 0; i < n; i++) {
            decorates[i] = sc.nextInt();
        }

        // 只需要知道连续的大于 K 的首尾是多少即可
        // 从中要选取 m 个连续的 这个条件还没有限制
        int res = 0;
        int preIndexes = -1;
        for (int i = 0; i < n; i++) {
            if (decorates[i] >= k) {
                if (preIndexes == -1) preIndexes = i;
                continue;
            }
            // 这个是仍然是小于 0 的点
            // 需要更新点的距离
            if (preIndexes == -1) continue;
            int len = i - preIndexes;
            // 长度不够不行
            if (len < m) {
                preIndexes = -1;
                continue;
            }
            // 现在是小于 k 的 要重置了 因为 i 遍历到下一个位置
            // 从 len 的长度中选 m 个连续的
            res += len - m + 1;

            preIndexes = -1;
        }
        // 这儿最开始没注意到
        if (preIndexes != -1) {
            int len = n - preIndexes;
            // 长度不够不行
            if (len >= m) {
                res += len - m + 1;
            }
        }

        System.out.println(res);
    }
}
