public class NthUglyNumber_264 {

    private static int[] factors = new int[]{2, 3, 5};

    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;

        int[] indexes = new int[]{0, 0, 0};

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < factors.length; j++) {
                min = Math.min(min, factors[j] * res[indexes[j]]);
            }
            res[i] = min;

            for (int j = 0; j < factors.length; j++) {
                while (min >= factors[j] * res[indexes[j]]) {
                    indexes[j]++;
                }
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber_264().nthUglyNumber(10));
        System.out.println(new NthUglyNumber_264().nthUglyNumber(1));
    }
}
