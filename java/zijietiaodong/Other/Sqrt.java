package Other;

public class Sqrt {
    public int mySqrt(int x) {
        long i = 0, j = x;
        while (i <= j) {
            long mid = (i + j) / 2;
            long temp = mid * mid;
            if (temp == x) {
                return (int) mid;
            } else if (temp > x) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return (int) j;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(8));
    }
}
