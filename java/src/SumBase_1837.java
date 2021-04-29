public class SumBase_1837 {

    // 10 进制的 n 转换为 k 进制
    // 问转换后 各位和为多少
    public int sumBase(int n, int k) {
        int res = 0;

        while (n != 0) {
            res += n % k;
            n = n / k;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SumBase_1837().sumBase(10, 6));
    }
}
