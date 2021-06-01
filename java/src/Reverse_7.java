public class Reverse_7 {

    public int reverse(int x) {
        int res = 0;
        boolean flag = false;
        if (x < 0) flag = true;
        if (x == Integer.MIN_VALUE) return 0;
        x = Math.abs(x);
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE - Integer.MAX_VALUE / 10 * 10)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return flag ? -res : res;
    }
}
