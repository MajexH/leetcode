public class NumDecodings_91 {

    // A -> 1 问这个字符串能够有几种几码方式 字符串为数字
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(s.length(), i + 2); j++) {
                if (can(s.substring(i, j))) {
                    dp[i] += dp[j];
                }
            }
        }

        return dp[0];
    }

    private boolean can(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int tmp = Integer.parseInt(s);
        return tmp >= 1 && tmp <= 26;
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings_91().numDecodings("12"));
        System.out.println(new NumDecodings_91().numDecodings("226"));
        System.out.println(new NumDecodings_91().numDecodings("0"));
        System.out.println(new NumDecodings_91().numDecodings("06"));
    }
}
