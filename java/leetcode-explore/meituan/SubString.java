package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubString {

    // 只包含 'E'、'F'
    private static int getMaxSubStringLen(String str) {
        List<Integer> list = new ArrayList<>();
        int pre = 0, last = 0;
        // 只有 E F 说明 以 F 作为分隔来进行的

        while (last < str.length()) {
            // 说明变换了
            if (str.charAt(last) != str.charAt(pre)) {
                if (str.charAt(last) == 'F') {
                    // 说明前面全是 E
                    list.add(last - pre);
                } else {
                    list.add(pre - last);
                }
                pre = last;
            }
            last++;
        }
        if (pre != last) {
            if (str.charAt(pre) == 'E') {
                list.add(last - pre);
            } else {
                list.add(pre - last);
            }
        }
        // 寻找连续子数组的最大和
        int res = 0;
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || dp[i - 1] < 0) {
                dp[i] = list.get(i);
            } else {
                dp[i] = dp[i - 1] + list.get(i);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 返回 E F 字母差值最大的子串 （只能是连续子串 从前面删去若干个字符 从后面删除若干个字符 最少删除一个字符）
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String str = sc.next();

        System.out.println(Math.max(getMaxSubStringLen(str.substring(0, str.length() - 1)), getMaxSubStringLen(str.substring(1))));
    }
}
