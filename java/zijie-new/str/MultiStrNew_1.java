package str;

public class MultiStrNew_1 {

    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int add = 0;
            int num1Temp = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = add + res[i + j + 1] + (num1Temp * (num2.charAt(j) - '0'));
                add = sum / 10;
                res[i + j + 1] = sum % 10;
            }
            if (add != 0) res[i] = add;
        }

        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int num : res) {
            if (flag && num == 0) continue;
            flag = false;
            builder.append(num);
        }
        if (flag) return "0";
        else return builder.toString();
    }
}
