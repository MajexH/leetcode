public class CountHomogenousNew_1759 {

    private static int mod = 1000000007;

    public int countHomogenous(String s) {
        long res = 0;
        int preIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(preIndex)) {
                int len = i - preIndex;
                res = (res + getSum(len)) % mod;
                preIndex = i;
            }
        }
        int len = s.length() - preIndex;
        res = (res + getSum(len)) % mod;
        return (int) res;
    }

    public long getSum(int i) {
        return ((long) (i + 1) * i) / 2;
    }
}
