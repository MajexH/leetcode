package arrayandstr;

public class Multiply {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];

        int add = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int number1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = number1 * (num2.charAt(j) - '0') + add + res[i + j + 1];
                res[i + j + 1] = temp % 10;
                add = temp / 10;
            }
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
}
