package highFrequency.str;

import java.util.Arrays;

/**
 * @author majexh
 */
public class StringAddAndMultiply {

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0) {
            int num1Int = i >= 0 ? num1.charAt(i) - '0' : 0;
            int num2Int = j >= 0 ? num2.charAt(j) - '0' : 0;

            int temp = add + num1Int + num2Int;
            add = temp / 10;
            builder.append(temp % 10);

            if (i >= 0) i--;
            if (j >= 0) j--;
        }
        if (add != 0) builder.append(add);
        return builder.reverse().toString();
    }

    public String multiplyStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] res = new int[num1.length() + num2.length()];


        for (int i = num1.length() - 1; i >= 0; i--) {
            int add = 0;
            int num1Int = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num2Int = num2.charAt(j) - '0';
                int temp = (num1Int * num2Int) + add + res[i + j + 1];
                add = temp / 10;
                res[i + j + 1] = temp % 10;
            }
            if (add != 0) {
                res[i] = add;
            }
        }
        System.out.println(Arrays.toString(res));
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int re : res) {
            if (flag && re == 0) {
                continue;
            }
            flag = false;
            builder.append(re);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // System.out.println(new StringAddAndMultiply().addStrings("0", "9"));
        System.out.println(new StringAddAndMultiply().multiplyStrings("123", "456"));
    }
}
