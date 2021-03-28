package meituan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class First {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();

        for (; T > 0; T--) {
            int n = sc.nextInt();

            String num = sc.next();
            if (n == 1) {
                out.write(String.valueOf(0));
                out.newLine();
                continue;
            }
            char[] nums = num.toCharArray();

            if (isPalindrome(nums)) {
                out.write(new String(nums));
                out.newLine();
                continue;
            }

            nums = num.toCharArray();

            for (int i = 0; i < n; i++) {
                if (nums[i] != '0') {
                    nums[i] = '0';
                    break;
                }
            }
            out.write(new String(nums));
            out.newLine();
        }
        out.flush();
    }

    public static boolean isPalindrome(char[] nums) {
        boolean change = false;
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            if (nums[i] == nums[j]) continue;
            if (!change) {
                change = true;
                nums[i] = getMin(nums[i], nums[j]);
                nums[j] = getMin(nums[i], nums[j]);
            } else {
                return false;
            }
        }
        if (i == j) {
            // 奇数要找到更小 需要把中间一个变为 0
            nums[i] = '0';
        }
        return true;
    }

    public static char getMin(char a, char b) {
        if (a > b) return b;
        return a;
    }
}
