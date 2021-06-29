package chapter3;

public class IsMatch_19 {

    public boolean isMatch(String s, String p) {
        return recursion(s, p, 0, 0);
    }

    public boolean recursion(String s, String p, int indexS, int indexP) {
        if (indexS == s.length() && indexP == p.length()) return true;
        if (indexS > s.length() && indexP == p.length()) return false;
        // 有可能 p 后面还有 * 所以 indexS == s.length() indexP != p.length() 的时候 可能还能匹配
        if (indexS > s.length() || indexP > p.length()) return false;
        if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
            if ((indexS < s.length() && s.charAt(indexS) == p.charAt(indexP)) || p.charAt(indexP) == '.') {
                // 前一个匹配
                return recursion(s, p, indexS, indexP + 2) || // 匹配 0 次
                        recursion(s, p, indexS + 1, indexP + 2) || // 匹配 1 次
                        recursion(s, p, indexS + 1, indexP); // 匹配多次
            } else {
                // 不相等 只能匹配 0 次
                return recursion(s, p, indexS, indexP + 2);
            }
        }

        // 这个时候要看到 两个是否相当
        return indexP < p.length() && indexS < s.length() && (p.charAt(indexP) == s.charAt(indexS) ||
                p.charAt(indexP) == '.') && recursion(s, p, indexS + 1, indexP + 1);
    }

    public static void main(String[] args) {
        System.out.println(new IsMatch_19().isMatch("ab", ".*c"));
        System.out.println(new IsMatch_19().isMatch("aa", "a*"));
        System.out.println(new IsMatch_19().isMatch("ab", ".*"));
        System.out.println(new IsMatch_19().isMatch("aab", "c*a*b"));
    }
}
