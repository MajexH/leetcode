package tencent.strAndArray;

public class Multiply {

    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int add = 0;
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int tmp = res[i + j + 1] + n1 * n2 + add;
                res[i + j + 1] = tmp % 10;
                add = tmp / 10;
            }
            if (add != 0) {
                res[i] += add;
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;

        for (int num : res) {
            if (num != 0) {
                flag = false;
            }
            if (flag) {
                continue;
            }
            builder.append(num);
        }
        if (builder.length() == 0) {
            return "0";
        }
        return builder.toString();
    }
}
