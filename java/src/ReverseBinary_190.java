public class ReverseBinary_190 {

    // 可以简单优化一下 可以直接把数字送到他对应的位置上
    public int reverseBits(int n) {
        int res = 0;
        // 将二进制表示颠倒
        // 因此这个地方可以在 n == 0 的时候停止
        for (int i = 0; i < 32 && n != 0; i++) {
            // 直接把数字运输到他需要的位置上
            res |= (n & 1) << (31 - i);
            // 无符号右移
            n >>>= 1;
        }
        return res;
    }

    // n 是无符号整数
    public int reverseBitsBruteForce(int n) {
        int res = 0;
        // 将二进制表示颠倒
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            // 无符号右移
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBinary_190().reverseBits(1));
    }
}
