package meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountNumber {

    // 小团想要编写一个程序，希望可以统计在M和N之间（M<N，且包含M和N）有多少个六位数ABCDEF满足以下要求：
    //
    //(1) ABCDEF这六个数字均不相同，即A、B、C、D、E和F表示六个不同的数字。
    //  题目有误 a c e 可以为 0
    //(2) AB+CD=EF。即将这个六位数拆成三个两位数，使得第1个和第2个两位数的和等于第3个两位数。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();
        int res = 0;
        while (m <= n) {
            if (isRequiredNum(m++)) res++;
        }
        System.out.println(res);
    }

    private static boolean isRequiredNum(int num) {
        char[] str = String.valueOf(num).toCharArray();

        Set<Character> set = new HashSet<>();
        for (char c : str) {
            set.add(c);
        }
        // 1. 判断是否是相同的数字
        if (set.size() != 6) return false;

        // 2. 判断 ab + cd == ef

        // 判断是否是正常的数字
        int first = isValidNumber(str[0], str[1]);
        int second = isValidNumber(str[2], str[3]);
        int sum = isValidNumber(str[4], str[5]);

        return first + second == sum;
    }

    private static int isValidNumber(char a, char b) {
        return (a - '0') * 10 + (b - '0');
    }
}
