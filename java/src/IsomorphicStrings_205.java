import java.util.Arrays;

public class IsomorphicStrings_205 {

    public int[] get(String s) {
        // p[i] 表示 s.charAt(i) 这个字符第一次出现的位置
        int[] pattern = new int[s.length()];
        // 保存当前字符串上的字符第一次出现的位置
        int[] memo = new int[255];
        Arrays.fill(memo, -1);
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (memo[temp] == -1) {
                memo[temp] = i;
                pattern[i] = i;
            } else {
                pattern[i] = memo[temp];
            }
        }
        return pattern;
    }

    // 同构的意思是说 s t 里面的形式是相同的
    // 如 abb foo
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] patternS = get(s), patternT = get(t);
        for (int i = 0; i < patternS.length; i++) {
            if (patternS[i] != patternT[i]) return false;
        }
        return true;
    }
}
