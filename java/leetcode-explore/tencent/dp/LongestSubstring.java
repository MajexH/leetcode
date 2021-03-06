package tencent.dp;

public class LongestSubstring {

    // 找到最长的子串 其中每个字符都出现次数大于等于 k 次
    public int longestSubstring(String s, int k) {
        // 边界条件
        if (s.length() < k) {
            return 0;
        }

        int[] memo = new int[26];
        for (char c : s.toCharArray()) {
            memo[c - 'a']++;
        }

        // 选取分隔点
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            // 进行分隔 因为他的数量在 string 中小于 k 一定不会包含在结果字符串里面
            if (memo[c - 'a'] > 0 && memo[c - 'a'] < k) {
                int res = 0;
                for (String tmp : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(tmp, k));
                }
                return res;
            }
        }
        // 整个字符串满足要求
        return s.length();
    }
}
