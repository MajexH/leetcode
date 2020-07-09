public class CountPrimes_204 {

    public boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // num % i 表示可以被 i 整除
            if (num % i == 0) return false;
        }
        return true;
    }
    // 这样直接每个数去判断 超时了
    public int countPrimes1(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) res++;
        }
        return res;
    }

    // 换一个思路
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes_204().countPrimes(1500000));
        System.out.println(new CountPrimes_204().countPrimes1(1500000));
    }
}
