public class Clumsy_1006 {

    private static char[] operators = new char[]{'*', '/', '+'};

    // 用 * / + - 的顺序 代替阶乘中的乘法
    public int clumsy(int N) {
        return recursion(N, true);
    }

    // 4 个 为一个阶段
    public int recursion(int n, boolean flag) {
        if (n <= 0) return 0;
        int res = flag ? n : -n;
        n--;
        for (int i = 0; i < 3 && n > 0; i++) {
            switch (operators[i]) {
                case '*':
                    res *= (n--);
                    break;
                case '/':
                    res /= (n--);
                    break;
                case '+':
                    res += (n--);
            }
        }
        return res + recursion(n, false);
    }

    public static void main(String[] args) {
        System.out.println(new Clumsy_1006().clumsy(4));
        System.out.println(new Clumsy_1006().clumsy(10));
    }
}
