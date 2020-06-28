public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;

        int sign;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) sign = 1;
        else sign = -1;

        int res = 0;
        // 如果使用int 保存32 位 当 dividend 取到 Integer.MIN_VALUE 的时候
        // 取abs 即取 -Integer.MIN_VALUE 这个时候回直接 取到 MAX_VALUE + 1
        // 造成溢出 又变成了 Integer.MIN_VALUE
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        while (dvd >= dvs) {

            long temp = dvs, m = 1;
            while (temp << 1 < dvd) {
                temp <<= 1;
                m <<= 1;
            }

            res += m;
            dvd -= temp;

        }
        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers_29().divide(-2147483648, 1));
    }
}
