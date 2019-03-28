package ClimbingStairs;

class Solution {

    public static int climb(int i, int n, int[] memo) {
        if (memo[i] > 0) {
            return memo[i];
        }
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        memo[i] = climb(i + 1, n, memo) + climb(i + 2, n, memo);
        return memo[i];
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 2];
        return climb(0, n, memo);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}