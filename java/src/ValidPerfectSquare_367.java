public class ValidPerfectSquare_367 {

    public boolean isPerfectSquare(int num) {
        long i = 0, j = num;
        while (i <= j) {
            long mid = (i + j) / 2;
            long multi = mid * mid;
            if (multi > num) {
                j = mid - 1;
            } else if (multi < num) {
                i = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(2147483647));
    }
}
