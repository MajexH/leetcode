import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Second {

    public static int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < str.length() - 1) {
            if (k == -1 || str.charAt(k) == str.charAt(j)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static boolean kmp(boolean[] memo, String str, String temp) {
        List<Integer> indexes = new ArrayList<>();
        int[] next = getNext(temp);
        int i = 0, j = 0;
        while (i < str.length() && j < temp.length()) {
            // 已经被删除
            // TODO： 这儿跳过的时候 有BUG alibaba 这个就是
            if (memo[i]) {
                i++;
            } else if (j == -1 || str.charAt(i) == temp.charAt(j)) {
                if (j != -1) {
                    // 表示可以删除
                    indexes.add(i);
                    memo[i] = true;
                }
                i++;
                j++;
            } else {
                j = next[j];
                if (j == - 1) continue;
                // 失配 恢复未删除状态
                for (int index : indexes) {
                    memo[index] = false;
                }
            }
            
        }
        return j == temp.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = sc.next();
        }
        // 表示当前这个char是否被删除
        boolean[] memo = new boolean[str.length()];
        while (true) {
            boolean flag = true;
            for (String temp : strs) {
                if (kmp(memo, str, temp)) {
                    flag = false;
                }
            }
            if (flag) break;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < memo.length; i++) {
            if (!memo[i]) {
                builder.append(str.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }
}
