package meituan;

import java.util.*;

public class Promote {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), x = sc.nextInt();
        // 但是同时 相等分数的人 也是可以计算在这个里面的
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp != 0) scores.add(tmp);
        }

        // 先计算出晋升的人数
        if (scores.size() <= x) System.out.println(scores.size());
        else {
            scores.sort((a, b) -> b - a);
            int score = scores.get(x);
            int j = x;

            while (j < scores.size() && score == scores.get(j)) {
                j++;
            }
            System.out.println(j);
        }
    }

    public static void mainOutDate(String[] args) {
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
