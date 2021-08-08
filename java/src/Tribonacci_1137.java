public class Tribonacci_1137 {

    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        if (n == 0) return a;
        else if (n == 1) return b;
        else if (n == 2) return c;

        for (int i = 3; i <= n; i++) {
            int tc = c;
            c = a + b + c;
            a = b;
            b = tc;
        }
        return c;
    }
}
