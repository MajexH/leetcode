package tencent.numberAndMath;

public class ReverseNumber {

    public int reverse(int x) {
        // 反转之后必定 gg
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int res = 0;
        boolean minus = false;
        if (x < 0) {
            minus = true;
            // x != Integer.MinValue
            x = Math.abs(x);
        }

        while (x != 0) {
            int add = x % 10;
            // 溢出
            if ((res == Integer.MAX_VALUE / 10 && add > Integer.MAX_VALUE % 10) || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + add;
            x /= 10;
        }

        return minus ? -res : res;
    }
}
