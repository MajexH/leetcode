package chapter3;

public class Power_16 {
    /**
     * 计算 base 的 n 次方
     * 不用考虑大数问题
     * @param base
     * @param n
     * @return
     */
    public double pow(int base, int n) {
        if (n == 0) return 1;
        boolean minus = false;
        if (n < 0) minus = true;
        double res = 1D;
        for (int i = 1; i <= Math.abs(n); i++) {
            res *= base;
        }
        return minus ? 1 / res : res;
    }

    /**
     * 使用 recursion 基于这样的思想
     * a^n = a ^ (n / 2) * a ^ (n / 2) n 为偶数的时候
     * 也就意味着
     * @param base
     * @param n
     * @return
     */
    public double powWithRecursion(int base, int n) {
        if (n == 0) return 1;
        boolean minus = false;
        if (n < 0) minus = true;
        double res = recursion(base, Math.abs(n));
        return minus ? 1 / res : res;
    }

    public double recursion(int base, int n) {
        if (n == 0) return 1D;
        if (n == 1) return base;
        double temp = recursion(base, n >> 1);
        temp = temp * temp;
        // 奇数情况
        if ((n & 0x1) == 1) temp *= base;
        return temp;
    }

    public static void main(String[] args) {
        Power_16 a = new Power_16();
        System.out.println(a.pow(2, 3));
        System.out.println(a.pow(2, -3));
        System.out.println(a.powWithRecursion(2, 3));
        System.out.println(a.powWithRecursion(2, -3));
    }
}
