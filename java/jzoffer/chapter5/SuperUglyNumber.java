package chapter5;

public class SuperUglyNumber {

    // 给定一个 factor 的数组 问丑数
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indexes = new int[primes.length];
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        for (int i = 1; i < n ; i++) {
            int min = Integer.MAX_VALUE;
            // 找到 primes 中当前最小的数
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * uglyNumbers[indexes[j]]);
            }
            uglyNumbers[i] = min;
            // 更新 indexes
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * uglyNumbers[indexes[j]] <= uglyNumbers[i]) {
                    indexes[j]++;
                }
            }
        }
        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(10, new int[]{2,3,5}));
    }
}
