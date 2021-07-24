public class LeastMinutes_LCS_01 {

    public int leastMinutes(int n) {
        if (n == 1) return 1;

        for (int i = 1; i <= n; i++) {
            if (Math.pow(2, i - 1) >= n) return i;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new LeastMinutes_LCS_01().leastMinutes(2));
        System.out.println(new LeastMinutes_LCS_01().leastMinutes(4));
    }
}
