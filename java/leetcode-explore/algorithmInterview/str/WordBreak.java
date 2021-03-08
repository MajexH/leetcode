package algorithmInterview.str;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // i 遍历的是 subString 不包括的末尾
        for (int i = 1; i <= s.length(); i++) {
            // 遍历开头 如果开头已经是能够分割的了 那么只需要剩下的部分能够分割即可
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
