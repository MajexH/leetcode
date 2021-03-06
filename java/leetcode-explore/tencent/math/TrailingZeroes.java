package tencent.math;

public class TrailingZeroes {

    // 统计 5 出现的次数
    public int trailingZeroes(int n) {
        int res = 0;

        while (n > 0) {
            n /= 5;
            res += n;
        }

        return res;
    }


}
