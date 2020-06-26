package str;

import java.util.Arrays;

/**
 * @author majexh
 */
public class MultiplyNew {

    public String multiply(String num1, String num2) {
        // 弄完了之后 可能还有一位进位
        int[] res = new int[num1.length() + num2.length()];
        Arrays.fill(res, 0);

        // 进位
        int add = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1Temp = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = num1Temp * (num2.charAt(j) - '0') + res[i + j + 1] + add;
                res[i + j + 1] = temp % 10;
                add = temp / 10;
            }
            // 每一次 都要判断 进位
            if (add != 0) {
                int temp = res[i] + add;
                res[i] = temp % 10;
                add = temp / 10;
            }
        }

        StringBuilder builder = new StringBuilder();

        boolean flag = true;

        for (int temp : res) {
            if (!flag || temp != 0) {
                flag = false;
                builder.append(temp);
            }
        }
        if (flag) {
            return "0";
        } else {
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyNew().multiply("0", "1"));
    }
}
