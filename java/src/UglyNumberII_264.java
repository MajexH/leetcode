import java.util.Arrays;
import java.util.Scanner;

public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        // 丑数的因子
        int[] factors = new int[]{2,3,5};
        // 每个因子对应的下一个丑数的下标
        int[] uglyNumberIndex = new int[factors.length];
        Arrays.fill(uglyNumberIndex, 0);

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < factors.length; j++) {
                min = Math.min(min, factors[j] * uglyNumber[uglyNumberIndex[j]]);
            }
            uglyNumber[i] = min;
            for (int j = 0; j < factors.length; j++) {
                while (factors[j] * uglyNumber[uglyNumberIndex[j]] <= min) {
                    uglyNumberIndex[j]++;
                }
            }
        }
        return uglyNumber[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII_264().nthUglyNumber(10));
    }
}
