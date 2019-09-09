package WordBreak139;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
//        return recursionWithMemo(s, wordDict, 0, new HashMap<>());
        return dpWithoutRecursion(s, wordDict);
    }

    public boolean find(List<String> dict, String s) {
        for (String temp : dict) {
            if (temp.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean recursionWithMemo(String str, List<String> dict, int start, Map<Integer, Boolean> memo) {
        if (start == str.length()) {
            memo.put(start, true);
            return true;
        }
        if (memo.containsKey(start)) return memo.get(start);
        boolean flag = false;
        for (int i = start + 1; i <= str.length(); i++) {
            // 如果第一个单词找到了
            if (find(dict, str.substring(start, i))) {
                // 这儿要后面所有的
                flag = flag || recursionWithMemo(str, dict, i, memo);
            }
        }
        memo.put(start, flag);
        return memo.get(start);
    }

    public boolean dpWithoutRecursion(String str, List<String> dict) {
        int length = str.length();
        // dp[i] 表示 i 下标的右边的字符word是在dict里面的
        boolean[] dp = new boolean[length + 1];
        // 空肯定在里面是找得到的
        dp[length] = true;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length; j > i; j--) {
                // 如果当前的i - j的字串是在dict里面 则要看j右边的字串是否为true
                // 为true i下标右边的字符串才都在dict里面
                if (find(dict, str.substring(i, j)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(new Solution().wordBreak("leetcode", list));
    }
}
