package highFrequency.math;

import java.util.HashSet;
import java.util.Set;

public class IsHappyNumber {

    private int getSum(int n) {
        int res = 0;
        while (n >= 1) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 1) {
            set.add(n);
            n = getSum(n);
            if (set.contains(n))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsHappyNumber().isHappy(19));
    }
}
