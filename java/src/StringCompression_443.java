import java.util.Arrays;

public class StringCompression_443 {

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int i = 0, j = 1;
        // 目标结果长度
        int res = 0;
        while (j < chars.length) {
            if (chars[i] != chars[j]) {
                if (j - i > 1) {
                    int index = 1;
                    String temp = String.valueOf(j - i);
                    chars[res] = chars[i];
                    while (index < 1 + temp.length()) {
                        chars[index + res] = temp.charAt(index - 1);
                        index++;
                    }
                    res += 1 + temp.length();
                } else {
                    chars[res] = chars[i];
                    res += 1;
                }
                i = j;
            }
            j++;
        }
        if (j - i > 1) {
            int index = 1;
            String temp = String.valueOf(j - i);
            chars[res] = chars[i];
            while (index < 1 + temp.length()) {
                chars[index + res] = temp.charAt(index - 1);
                index++;
            }
            res += 1 + temp.length();
        } else {
            chars[res] = chars[i];
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression_443().compress(new char[]{ 'a','a','a','a','a','b'}));
    }
}
