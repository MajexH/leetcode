package chapter6;

public class TransferStrToNumber_67 {

    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int start = 0;
        boolean minus = false;
        if (str.charAt(0) == '-') {
            minus = true;
            start++;
        } else if (str.charAt(0) == '+') {
            start++;
        }
        int sum  = 0;

        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            int add = str.charAt(i) - '0';
            // 溢出
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && add > Integer.MAX_VALUE - (Integer.MAX_VALUE / 10) * 10)) {
                return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && add < Integer.MAX_VALUE - (Integer.MAX_VALUE / 10) * 10)) {
                return Integer.MIN_VALUE;
            }
            sum  = sum * 10 + add;
        }
        return minus ? -sum : sum;
    }

    public static void main(String[] args) {
//        System.out.println(new TransferStrToNumber_67().strToInt("42"));
//        System.out.println(new TransferStrToNumber_67().strToInt("   -42"));
//        System.out.println(new TransferStrToNumber_67().strToInt("4193 with words"));
//        System.out.println(new TransferStrToNumber_67().strToInt("words and 987"));
        System.out.println(new TransferStrToNumber_67().strToInt("-91283472332"));
    }
}
