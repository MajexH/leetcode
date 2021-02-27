public class LongestSubstring_395 {

    // 不停的分治去递归
    // 因为一个结果字符串里面肯定不会包含 小于 k 的
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        int[] memo = new int[26];
        for (char c : s.toCharArray()) {
            memo[c - 'a']++;
        }

        // 枚举作为分隔的字符
        for (int i = 0; i < 26; i++) {
            // 分隔
            if (memo[i] > 0 && memo[i] < k) {
                int res = 0;
                // 以这个不可能的字符为分隔 分隔所有的可能能形成的分隔端
                // 然后在每个分隔段上 再次分隔 得到其最大值
                for (String tmp : s.split(String.valueOf((char) (i + 'a')))) {
                    res = Math.max(res, longestSubstring(tmp, k));
                }
                return res;
            }
        }
        // 整个字符串 每个字符的长度都 大于等于 k
        return s.length();
    }


    // 要求子串中的所有出现次数都不少于 k 次
    // 滑动窗口不好想，因为他不是用题目条件来滑动
    // 而是定义了一个 字母种类 在字母种类上滑动
    // 而原始条件确实没办法滑动
    public int longestSubstringWithSlidingWindow(String s, int k) {
        // 因为 s 中只包含小写字母 所以 可以遍历 看窗口里面有多少个字母 & 满足要求
        int res = 0;
        // 窗口中的最大字母种类数
        for (int i = 1; i <= 26; i++) {
            // 保存窗口中的 26 个字母
            int[] memo = new int[26];
            // 保存窗口中的字母种类数
            int total = 0;
            // 保存窗口中小于等于 k 的字母的总数 可以依据这个判断
            int less = 0;
            int l = 0, r = 0;

            while (r < s.length()) {
                memo[s.charAt(r) - 'a']++;
                // 新增的
                if (memo[s.charAt(r) - 'a'] == 1) {
                    total++;
                    less++;
                }
                if (memo[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                // 种类过多的话 删除种类
                while (total > i) {
                    memo[s.charAt(l) - 'a']--;
                    // 接近 0 的一定小于 k 了
                    if (memo[s.charAt(l) - 'a'] == 0) {
                        total--;
                        less--;
                    }
                    if (memo[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    l++;
                }

                if (less == 0) {
                    res = Math.max(res, r - l + 1);
                }

                r++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LongestSubstring_395().longestSubstring("ababbc", 2));
        System.out.println(new LongestSubstring_395().longestSubstring("aaabb", 3));
        System.out.println(new LongestSubstring_395().longestSubstring("bbaaacbd", 3));
        System.out.println(new LongestSubstring_395().longestSubstring("a", 1));
    }
}
