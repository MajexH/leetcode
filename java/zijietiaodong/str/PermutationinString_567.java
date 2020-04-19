package str;

public class PermutationinString_567 {

    /**
     * 判断s1的某个 排列 是否是 s2 的子串
     * 下面采用滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        // 初始化滑动窗口
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        // 这个地方就是让s2Map在滑动 每次从里面减少一个最前面的 加上一个滑动窗口最后面的
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (checkMap(s1Map, s2Map)) return true;
            s2Map[s2.charAt(i + s1.length()) - 'a']++;
            s2Map[s2.charAt(i) - 'a']--;
        }
        return checkMap(s1Map, s2Map);
    }

    /**
     * 判断s1的某个 排列 是否是 s2 的子串
     * 下面是采用map来做的
     * 因为要找的是排列 是否是 s2 的子串
     * 因此只需要 s2 的某个子串里面的字母和出现的次数跟 s1 是相同的就可以是一个排列
     * 因此只需要用map来记录当前访问的字符串的出现次数和字符 就可以知道是否是一个排列
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int[] s1Map = new int[26];
        int[] s2Map;
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            s2Map = new int[26];
            for (int j = i; j < i + s1.length(); j++) {
                s2Map[s2.charAt(j) - 'a']++;
            }
            if (checkMap(s1Map, s2Map)) return true;
        }
        return false;
    }

    public boolean checkMap(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationinString_567().checkInclusion("ab", "eidbaooo"));
    }
}
