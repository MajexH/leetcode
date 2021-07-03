public class ArrangeCoins_441 {

    public int arrangeCoins(int n) {
        long sum = 0;
        int i = 0;
        for (; sum <= n; i++) {
            sum += i;
        }
        return sum == n ? i - 1 : i - 2;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangeCoins_441().arrangeCoins(5));
        System.out.println(new ArrangeCoins_441().arrangeCoins(8));
    }
}
