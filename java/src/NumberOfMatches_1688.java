public class NumberOfMatches_1688 {

    public int numberOfMatches(int n) {
        int res = 0;

        while (n != 1) {
            // 基数
            if ((n & 1) == 1) {
                res += n / 2;
                n = n / 2 + 1;
            } else {
                // 偶数
                res += n / 2;
                n = n / 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfMatches_1688().numberOfMatches(7));
        System.out.println(new NumberOfMatches_1688().numberOfMatches(14));
    }
}
