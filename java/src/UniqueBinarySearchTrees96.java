import java.util.Arrays;

public class UniqueBinarySearchTrees96 {

    public int recursion(int n, int[] memo) {
        if (n <= 1) return 1;
        if (memo[n] != -1) return memo[n];
        int sum = 0;
        // i 代表左子树有多少个
        // 而因为要选取一个作为根 因此只到 n-1
        for (int i = 0; i < n; i++) {
            sum += recursion(i, memo) * recursion(n - i - 1, memo);
        }
        memo[n] = sum;
        return sum;
    }

    public int numTrees(int n) {
//        int[] memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        return recursion(n, memo);
        return iterate(n);
    }

    public int iterate(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees96().numTrees(3));
    }
}
