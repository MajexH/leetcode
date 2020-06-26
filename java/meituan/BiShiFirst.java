public class BiShiFirst {

    public int resolve(String input) {
        // dp 表示以 input[i] 开始的能够形成多少个转换
        int[] dp = new int[input.length() + 1];
        // 这个地方为 1 其实表示了 这种划分 能够把前面的数字正好全部划分完 是一种可能的转换
        dp[input.length()] = 1;
        for (int i = dp.length - 1; i >= 0; i--) {
            // 因为字母最大到 26 因此最多只需要找两位数字即可
            for (int j = 1; j <= 2; j++) {
                if (i + j <= input.length() && valid(input.substring(i, i + j)))
                    dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }

    public boolean valid(String str) {
        // 可能存在 101 这个时候 1 0 1 单独分开是不行的 而且 1 01 也不行
        if (str.length() == 0 || str.startsWith("0")) return false;
        return Integer.parseInt(str) >= 1 && Integer.parseInt(str) <= 26;
    }
    public static void main(String[] args) {
        System.out.println(new BiShiFirst().resolve("101"));
    }
}
