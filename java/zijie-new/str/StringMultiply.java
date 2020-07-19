package str;

public class StringMultiply {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
        int[] res = new int[num1.length() + num2.length()];

        int add = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1Temp = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num2Temp = num2.charAt(j) - '0';
                int sum = add + res[i + j + 1] + (num1Temp * num2Temp);
                res[i + j + 1] = sum % 10;
                add = sum / 10;
            }
            if (add != 0) {
                res[i] = add;
                add = 0;
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;

        for (int num : res) {
            if (flag && num == 0) continue;
            flag = false;
            builder.append(num);
        }
        if (flag) return "0";
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringMultiply().multiply("123", "456"));
    }
}
