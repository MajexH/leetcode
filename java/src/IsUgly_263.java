public class IsUgly_263 {

    private static int[] factors = new int[]{2, 3, 5};

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        while (n > 1) {
            boolean flag = true;
            for (int factor : factors) {
                if (n % factor == 0) {
                    n /= factor;
                    flag = false;
                    break;
                }
            }
            if (flag) return false;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new IsUgly_263().isUgly(6));
        System.out.println(new IsUgly_263().isUgly(8));
        System.out.println(new IsUgly_263().isUgly(14));
    }
}
