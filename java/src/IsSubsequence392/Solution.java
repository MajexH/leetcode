package IsSubsequence392;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public boolean isSubsequence1(String s, String t) {
        int[][] memo = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return recursion1(s, t, 0, 0, memo);
    }

    public boolean recursion1(String s, String t, int sIndex, int tIndex, int[][] memo) {
        if (sIndex == s.length()) return true;
        if (tIndex == t.length()) return false;

        if (memo[sIndex][tIndex] != -1) {
            return memo[sIndex][tIndex] == 1;
        }
        boolean res;
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            res = recursion1(s, t, sIndex + 1, tIndex + 1, memo) || recursion1(s, t, sIndex, tIndex + 1, memo);
        } else {
            res = recursion1(s, t, sIndex, tIndex + 1, memo);
        }
        memo[sIndex][tIndex] = res ? 1 : 0;
        return res;
    }

    public boolean isSubsequence2(String s, String t) {
        return recursion(s, t, 0, 0);
    }

    public boolean recursion(String s, String t, int sIndex, int tIndex) {
        if (sIndex == s.length()) return true;
        if (tIndex == t.length()) return false;

        boolean res;
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            res = recursion(s, t, sIndex + 1, tIndex + 1) || recursion(s, t, sIndex, tIndex + 1);
        } else {
            res = recursion(s, t, sIndex, tIndex + 1);
        }
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j] = i == 0;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
    }
}
