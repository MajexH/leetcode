package str;

public class MultiplyStr {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int add = 0;
            int num1Int = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num2Int = num2.charAt(j) - '0';
                int temp = add + res[i + j + 1] + (num1Int * num2Int);
                res[i + j + 1] = temp % 10;
                add = temp / 10;
            }
            if (add != 0) {
                res[i] = add;
            }
        }

        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < res.length; i++) {
            if (flag && res[i] == 0) continue;
            flag = false;
            builder.append(res[i]);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStr().multiply("123", "0"));
    }
}
