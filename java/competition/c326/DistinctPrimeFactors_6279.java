package competition.c326;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctPrimeFactors_6279 {

    public static void main(String[] args) {
        DistinctPrimeFactors_6279 solution = new DistinctPrimeFactors_6279();

        System.out.println(solution.distinctPrimeFactors(new int[]{2, 4, 3, 7, 10, 6}));
        System.out.println(solution.distinctPrimeFactors(new int[]{2, 4, 8, 16}));
    }

    private static final List<Integer> PRIMES = new ArrayList<>();

    static {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                PRIMES.add(i);
            }
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> res = new HashSet<>();

        for (int num : nums) {

            for (int prime : PRIMES) {
                if (num % prime == 0) {
                    res.add(prime);
                }
            }
        }

        return res.size();
    }
}
