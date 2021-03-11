package meituan;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Promote {

    public static void main(String[] args) {
        // 计算晋级的实际人数
        // 所以得分不为 0 且 分数比 第 x 个人高的都可以
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), x = sc.nextInt();
        // 但是同时 相等分数的人 也是可以计算在这个里面的
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
           scores[i] = sc.nextInt();
        }

        Arrays.sort(scores);

        int index = n - x;
        if (scores[index] == 0) {
            // 说明要往前找到第一个不为 0 的地方
            while (index < scores.length && scores[index] == 0) {
                index++;
            }
            System.out.println(n - index);
        } else {
            int base = scores[index];
            // 找相同的
            while (index >= 0 && scores[index] == base) {
                index--;
            }
            System.out.println(n - 1 - index);
        }
    }
}
