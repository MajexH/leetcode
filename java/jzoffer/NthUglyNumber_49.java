public class NthUglyNumber_49 {

    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;

        int[] factors = new int[]{2,3,5};
        int[] indexes = new int[]{0,0,0};

        for (int i = 1; i < n; i++) {
            int uglyNum = Integer.MAX_VALUE;
            for (int j = 0; j < factors.length; j++) {
                uglyNum = Math.min(factors[j] * res[indexes[j]], uglyNum);
            }
            // 先赋值的话 后面就可以比较引用了 不用再判断增长的上线
            res[i] = uglyNum;
            for (int j = 0; j < factors.length; j++) {
                while (factors[j] * res[indexes[j]] <= uglyNum) {
                    indexes[j]++;
                }
            }

        }

        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber_49().nthUglyNumber(10));
        System.out.println(new NthUglyNumber_49().nthUglyNumber(4));
    }
}
