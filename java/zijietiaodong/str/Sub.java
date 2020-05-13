package str;

public class Sub {

    public String sub(String num1, String num2) {

        // TODO: valid
        if (num1.length() > num2.length()) {
            return subStr(num1, num2);
        } else if (num1.length() < num2.length()) {
            return "-" + subStr(num2, num1);
        } else {
            if (num1.compareTo(num2) > 0)
                return subStr(num1, num2);
            else if (num1.compareTo(num2) < 0)
                return "-" + subStr(num2, num1);
            else
                // 完全相同的字符串
                return "0";
        }
    }

    public String subStr(String max, String min) {
        int i = max.length() - 1, j = min.length() - 1;
        int[] res = new int[i + 1];
        int borrow = 0;
        while (i >= 0) {
            int maxNum = max.charAt(i) - '0';
            int minNum = j >= 0 ? min.charAt(j) - '0' : 0;

            int temp = maxNum - minNum - borrow + 10;
            res[i] = temp % 10;
            // 因为之前加了10 现在如果结果比10小 说明需要借位
            borrow = temp < 10 ? 1 : 0;
            i--;
            j--;
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int num : res) {
            if (num == 0 && flag) {
            } else {
                flag = false;
                builder.append(num);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Sub().sub("124", "123"));
    }
}
