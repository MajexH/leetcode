package MultiplyStrings;

public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] resultNumber = new int[num1.length() + num2.length()];

        for (int j = num2.length() - 1; j >=0; j--) {
            int num2J = num2.charAt(j) - '0';
            // 进位
            int carry = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int num1I = num1.charAt(i) - '0';
                int temp = num2J * num1I + carry + resultNumber[i + j + 1];
                carry = temp / 10;
                resultNumber[i + j + 1] = temp % 10;
            }
            // 保证在一个循环结束时有进位 进位会被存储
            if (carry > 0) {
                resultNumber[j] = carry;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < resultNumber.length; i++) {
            if (i == 0 && resultNumber[i] == 0) {
                continue;
            }
            builder.append(resultNumber[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));
    }
}
