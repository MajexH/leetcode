public class TrailingZeroes_172 {

    // 从上面那个超时的解法 可以知道
    // 其实只需要找到 里面有多少个 5 即可
    // 实际上 只对 5 的倍数感兴趣
    // 找到里面 5 的倍数有多少个即可
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }

    // 这个解法 超时了
    public int trailingZeroes1(int n) {
        // 因为 只有 2 * 5 可以等于 10
        // 那么只需要知道有多少个 2 和 多少个 5 即可
        // 然而由于 2 的数量一定比 5 多
        // 因此 只需要计算有多少个 5 即可
        int res = 0;
        for (int i = 5; i <= n; i += 5) {
            int temp = i;
            while (temp % 5 == 0) {
                res++;
                temp /= 5;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes_172().trailingZeroes(1808548329));
    }
}
