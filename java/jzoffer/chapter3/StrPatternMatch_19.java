package chapter3;

public class StrPatternMatch_19 {

    /**
     * 正则表达式的匹配 其中 s 是带匹配字符串 p 是模式串
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return recursion(s, p, 0, 0);
    }

    public boolean recursion(String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) return true;
        // 这儿这么写的原因是因为 有可能 pIndex 指向的是一个 * 因此只有 s 被遍历完 p 没有被遍历完 才是可能失败的
        if (sIndex > s.length() && p.length() == pIndex) return false;
        // 越界
        if (sIndex > s.length() || pIndex > p.length()) return false;
        // 如果是 * 的话 可以匹配 0 次 和 多次
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            // 如果是匹配的
            if (p.charAt(pIndex) == '.' || (sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex))) {
                        // 匹配一次就跳过
                return recursion(s, p, sIndex + 1, pIndex + 2) ||
                        // 匹配多次
                        recursion(s, p, sIndex + 1, pIndex) ||
                        // 匹配0次
                        recursion(s, p, sIndex, pIndex + 2);
            } else {
                // 其他情况下 只能匹配 0 次
                return recursion(s, p, sIndex, pIndex + 2);
            }
        }
        // 当前字符是匹配的
        if (pIndex < p.length() && sIndex < s.length() && (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex)))
            return recursion(s, p, sIndex + 1, pIndex + 1);
        // 兜底
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new StrPatternMatch_19().isMatch("ab", ".*c"));
        System.out.println(new StrPatternMatch_19().isMatch("a", "ab*"));
        System.out.println(new StrPatternMatch_19().isMatch("ab", ".*"));
        System.out.println(new StrPatternMatch_19().isMatch("aab", "c*a*b"));
        System.out.println(new StrPatternMatch_19().isMatch("mississippi", "mis*is*p*."));
    }
}
