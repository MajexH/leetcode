public class CountPalindromicSubsequence_1930 {

    // 既然是 三个字母 那么只需要固定两个字母的边界
    // 看中间有多少个 独立的字母即可
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        boolean[] memo = new boolean[26];
        for (int i = 0; i < s.length() - 1; i++) {
            if (memo[s.charAt(i) - 'a']) continue;
            // 保存中间的字母是否访问过
            boolean[] tmpMemo = new boolean[26];
            // counter 进行累计中间的 distinct 的字母
            int counter = 1;
            tmpMemo[s.charAt(i + 1) - 'a'] = true;
            for (int j = i + 2; j < s.length(); j++) {
                // 相等 说明中间可以构成一个回文数
                if (s.charAt(i) == s.charAt(j)) {
                    memo[s.charAt(i) - 'a'] = true;
                    res += counter;
                    // 重新置位
                    counter = 0;
                }
                // 进行 counter 累加
                if (!tmpMemo[s.charAt(j) - 'a']) {
                    counter++;
                    tmpMemo[s.charAt(j) - 'a'] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(new CountPalindromicSubsequence_1930().countPalindromicSubsequence("tppt"));
        System.out.println(new CountPalindromicSubsequence_1930().countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"));
        System.out.println(new CountPalindromicSubsequence_1930().countPalindromicSubsequence("adc"));
        System.out.println(new CountPalindromicSubsequence_1930().countPalindromicSubsequence("bbcbaba"));
    }
}
