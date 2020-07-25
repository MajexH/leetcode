package chapter2.bite;

public class NumberOf1InBinary_15 {

    /**
     * 得到一个数字的二进制中的1的个数
     * @param num
     * @return
     */
    public int getNumberOf1InBinary(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            // 这样可以把 num 这个数的最右边的一个 1 置位 0
            num = num & (num - 1);
        }
        return res;
    }

    public int getNumberOf1InBinaryAnother(int num) {
        int andNumber = 1;
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            if ((num & andNumber) > 0) res++;
            andNumber <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1InBinary_15 a = new NumberOf1InBinary_15();
        System.out.println(a.getNumberOf1InBinary(9));
        System.out.println(a.getNumberOf1InBinaryAnother(9));
    }
}
