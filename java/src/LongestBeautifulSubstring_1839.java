public class LongestBeautifulSubstring_1839 {

    private static char[] characters = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int longestBeautifulSubstring(String word) {

        int cIndex = 0, preA = 0;
        int res = 0;
        boolean first = true, last = false;

        for (int i = 0; i < word.length();) {
            char cur = word.charAt(i);

            if (cur != characters[cIndex]) {
                if (cur != 'a') {
                    // == 'a' 说明可以重新开始 就不能跳过这个字符
                    i++;
                }
                first = true;
                cIndex = 0;
                last = false;
                continue;
            }
            if (cur == 'u') last = true;
            while (cur == characters[cIndex]) {
                if (first) {
                    first = false;
                    preA = i;
                }
                i++;
                if (i >= word.length()) break;
                cur = word.charAt(i);
            }
            cIndex++;
            if (last) {
                res = Math.max(res, i - preA);
                cIndex = 0;
                first = true;
                last = false;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestBeautifulSubstring_1839().longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(new LongestBeautifulSubstring_1839().longestBeautifulSubstring("a"));
    }
}
