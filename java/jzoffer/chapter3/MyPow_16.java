package chapter3;

public class MyPow_16 {

    public double myPow(double x, int n) {
        boolean flag = n < 0;
        double res = recursion(x, n);

        return flag ? 1 / res : res;
    }

    public double recursion(double x, int n) {
        if (n == 0) return 1;

        double tmp = recursion(x, n / 2);
        tmp = tmp * tmp;
        if ((n & 1) == 1) {
            tmp *= x;
        }
        return tmp;
    }
}
