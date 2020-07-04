import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakNew_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // dp[i] 表示前 i - 1 个字符的能否形成
        boolean[] dp = new boolean[s.length() + 1];
        // 空字符串肯定可以在 dict 里面找到
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[j - 1] && set.contains(s.substring(j - 1, i));
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreakNew_139().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
