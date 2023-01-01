package competition.c326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ClosestPrimes_6280 {

    public static void main(String[] args) {
        ClosestPrimes_6280 solution = new ClosestPrimes_6280();
        System.out.println(Arrays.toString(solution.closestPrimes(10, 19)));
        System.out.println(Arrays.toString(solution.closestPrimes(1, 10000)));
    }

    public int[] closestPrimes(int left, int right) {
        // 筛除法
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i <= right; i++) {
            if (isPrime[i]) {
                // 倍数不是质数
                for (int j = 2 * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        // 找到差值最小的两个数据 而且 i 更小 差值最小的一定是相邻的
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < primes.size() - 1; i++) {
            int a = primes.get(i), b = primes.get(i + 1);

            if (b - a >= diff) {
                continue;
            }
            diff = b - a;
            res = new int[]{a, b};
        }

        return res;
    }

    public int[] closestPrimesBruteForce(int left, int right) {

        Integer prePrime = null;
        int diff = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};
        for (int i = left; i <= right; i++) {
            if (!this.isPrime(i)) {
                continue;
            }

            // 如果 prePrime 不为空 就开始比较
            if (Objects.isNull(prePrime) || i - prePrime >= diff) {
                prePrime = i;
                continue;
            }

            diff = i - prePrime;
            res = new int[]{prePrime, i};
            prePrime = i;
        }

        return res;
    }

    private boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
