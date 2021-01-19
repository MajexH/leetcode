public class RegularExpression_10 {
    public boolean isMatch(String s, String p) {
        return recursion(s, p, 0, 0);
    }

    public boolean recursion(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length() && sIndex != s.length()) {
            return false;
        }

        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }

        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            if (sIndex < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex))) {
                return recursion(s, p, sIndex, pIndex + 2) || // 匹配0次
                        recursion(s, p, sIndex + 1, pIndex + 2) || // 匹配1次
                        recursion(s, p, sIndex + 1, pIndex); // 匹配多次
            } else {
                return recursion(s, p, sIndex, pIndex + 2);
            }
        }
        if (sIndex < s.length() && pIndex < p.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex))) {
           return recursion(s, p, sIndex + 1, pIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpression_10().isMatch("aa", "a*"));
    }
}