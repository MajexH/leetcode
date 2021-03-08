package microsoft;

public class CountDigitOne {

    // 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
    // 十进制的 1
    public int countDigitOne(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += count(i);
        }
        return res;
    }

    public int count(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10 == 1 ? 1 : 0;
            n /= 10;
        }
        return res;
    }
}
