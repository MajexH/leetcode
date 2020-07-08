public class ReverseBits_190 {

    public int reverseBits(int n) {
        int res = 0;
        // 最高位是符号位
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits_190().reverseBits(43261596));
    }
}
