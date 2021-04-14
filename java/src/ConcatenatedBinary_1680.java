public class ConcatenatedBinary_1680 {

    private static int mod = 1000000007;

    // 只需要知道遍历的 n 的位数的长度即可
    public int concatenatedBinary(int n) {
        long res = 0;
        int shift = 0;
        // 因为要返回的是 1 - n 的数字的二进制的组合形成的大数字的十进制数
        // 比如 1 2 3 组成的 1 10 11 返回 27
        // 相当于 首先访问 1 结果为 1
        // 访问 2 然后 1 左移两位 再加上 2
        // 访问 3 上一步的结果 再左移两位 加上 3
        // 所以对于每一个数字来说 实际上只需要让上一次的结果 不停的左移它的二进制的位数长度即可
        for (int i = 1; i <= n; i++) {
            // 因为二的幂次方为 1000 的形式
            // 所以一旦知道现在的 i 为 2 的幂次方 就需要 shift++
            if ((i & (i - 1)) == 0) {
                shift++;
            }
            res = ((res << shift) + i) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new ConcatenatedBinary_1680().concatenatedBinary(12));
    }
}
