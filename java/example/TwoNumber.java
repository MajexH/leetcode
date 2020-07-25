public class TwoNumber {

    // 大整数相加
    public String add(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int add = 0;
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int temp1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int temp2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;

            int sum = temp1 + temp2 + add;
            add = sum / 10;
            builder.append(sum % 10);
            if (index1 >= 0) index1--;
            if (index2 >= 0) index2--;
        }
        if (add != 0) builder.append(add);
        return builder.reverse().toString();
    }

    // 大整数相乘
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int add = 0;
            int num1Temp = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num1Temp * (num2.charAt(j) - '0')) + res[i + j + 1] + add;
                res[i + j + 1] = temp % 10;
                add = temp / 10;
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

    // 大整数相减 num1 - num2
    public String sub(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return subPrivate(num1, num2);
        } else if (num1.length() < num2.length()) {
            return "-" + subPrivate(num2, num1);
        } else {
            if (num1.compareTo(num2) > 0) return subPrivate(num1, num2);
            else if (num1.compareTo(num2) < 0) return "-" + subPrivate(num2, num1);
            else return "0";
        }
    }

    private String subPrivate(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int subNumber = 0;
        while (index1 >= 0 || index2 >= 0) {
            int num1Temp = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int num2Temp = index2 >= 0 ? num2.charAt(index2) - '0' : 0;

            int subRes = num1Temp - num2Temp - subNumber + 10;

            builder.append(subRes % 10);
            subNumber = subRes < 10 ? 1 : 0;
            if (index1 >= 0) index1--;
            if (index2 >= 0) index2--;
        }
        for (int i = builder.length() - 1; i >= 0; i--) {
            if (builder.charAt(i) == '0') {
                builder.deleteCharAt(i);
            } else {
                break;
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new TwoNumber().sub("100", "9"));
    }
}
