public class BitwiseANDofNumbersRange_201 {

    // 本体求的是 m 到 n 的所有数的 按位与
    // 直接 & 操作会超时
    // 但是 m -> n 的数儿有一个特点
    // 就是是从 m + 1 -> n 的
    // 也就是说 每个数儿只会相差一位
    // 那么这样相差 1 的数 如果与起来的话 肯定最后相差 1 的那位
    // 会是 0
    // 因此 m n 一定会有相同的前缀
    // 找到这个前缀即可
    public int rangeBitwiseAnd(int m, int n) {
        // 这句话是为了效率 可以提高一点效率
        if (m == 0) return 0;
        // 记录 m n 的后缀有多少是不同的
        int lastZeroBits = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            lastZeroBits++;
        }
        return m << lastZeroBits;
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseANDofNumbersRange_201().rangeBitwiseAnd(5, 7));
    }
}
