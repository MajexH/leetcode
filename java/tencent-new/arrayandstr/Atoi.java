package arrayandstr;

public class Atoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) return 0;
        // 去除空格
        str = str.trim();

        long num = 0;
        boolean minus = str.charAt(0) == '-';
        boolean flag = minus || str.charAt(0) == '+';

        for (int i = flag ? 1 : 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            // 首位非数字
            if (((!minus && i == 0) || (minus && i == 1)) && (temp < '0' || temp > '9')) return 0;
            if (temp >= '0' && temp <= '9') {
                num = num * 10 + temp - '0';
                // num 只会大于0 如果溢出 则会小于0
                if (num > Integer.MAX_VALUE) {
                    return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                // 其它字符
                break;
            }
        }
        return minus ? -(int)num : (int) num;
    }

    public static void main(String[] args) {
        Atoi a = new Atoi();
        System.out.println(a.myAtoi("-6147483648"));
        System.out.println(a.myAtoi("+1"));
        System.out.println(a.myAtoi("3.14159"));
        System.out.println(a.myAtoi("42"));
        System.out.println(a.myAtoi("   -42"));
        System.out.println(a.myAtoi("4193 with words"));
        System.out.println(a.myAtoi("words and 987"));
        System.out.println(a.myAtoi("-91283472332"));
    }
}
