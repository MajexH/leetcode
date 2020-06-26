import java.util.Arrays;
import java.util.Scanner;

public class First {

    public static int[] getNext(String str) {
        int[] next = new int[str.length() + 1];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < str.length()) {
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

    public static String resolve(int n, int k, String base) {
        // kmp next 数组找前后缀最长长度
        int[] next = getNext(base);
        // 其中最后一位代表的就是 开头的前后缀的 最长长度
        int counter = next[base.length()];

        StringBuilder builder = new StringBuilder();
        builder.append(base);
        while (k > 1) {
            builder.append(base.substring(counter));
            k--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        String base = scanner.next();
        System.out.println(resolve(n, k, base));
    }
}
