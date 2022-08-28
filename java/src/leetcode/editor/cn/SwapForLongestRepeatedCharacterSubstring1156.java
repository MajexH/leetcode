//如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
//
// 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。 
//
// 
//
// 示例 1： 
//
// 输入：text = "ababa"
//输出：3
// 
//
// 示例 2： 
//
// 输入：text = "aaabaaa"
//输出：6
// 
//
// 示例 3： 
//
// 输入：text = "aaabbaaa"
//输出：4
// 
//
// 示例 4： 
//
// 输入：text = "aaaaa"
//输出：5
// 
//
// 示例 5： 
//
// 输入：text = "abcdef"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 20000 
// text 仅由小写英文字母组成。 
// 
//
// Related Topics 字符串 滑动窗口 👍 95 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwapForLongestRepeatedCharacterSubstring1156 {
    public static void main(String[] args) {
        Solution solution = new SwapForLongestRepeatedCharacterSubstring1156().new Solution();
        System.out.println(solution.maxRepOpt1("ababa"));
        System.out.println(solution.maxRepOpt1("aaabaaa"));
        System.out.println(solution.maxRepOpt1("aaabbaaa"));
        System.out.println(solution.maxRepOpt1("aaaaa"));
        System.out.println(solution.maxRepOpt1("abcdef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final class Pair {
            int start, end;

            public Pair(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public int maxRepOpt1(String text) {
            Map<Character, List<Pair>> characterMap = new HashMap<>();

            for (int i = 0; i < text.length(); ) {
                int j = i + 1;
                while (j < text.length() && text.charAt(i) == text.charAt(j)) {
                    j++;
                }
                characterMap.computeIfAbsent(text.charAt(i), key -> new ArrayList<>())
                        .add(new Pair(i, j - 1));
                i = j;
            }

            int res = 0;

            // 三种情况
            // 1. 只有 key pairs 的连续字符
            // 2. aabaa 中间只有一个相隔
            //    这个时候 只要有其他的字符可以最大值为练个相加
            //    或者还有更大的可能就是如果有 三对 aabaa aa 那么可以把其他对数的拿过来比较 所以可以还可以加 1
            // 3. aabbaa 中间有多个相隔
            for (char key : characterMap.keySet()) {
                List<Pair> keyPairs = characterMap.get(key);

                for (int i = 0; i < keyPairs.size(); i++) {
                    Pair p = keyPairs.get(i);
                    // 符合第一种情况
                    res = Math.max(res, p.end - p.start + 1);
                    // 第三种情况 中间有多个相隔的情况 只能取一个 + 1
                    res = Math.max(res, p.end - p.start + 1 + (keyPairs.size() > 1 ? 1 : 0));
                    // 第二种情况
                    // 由于 key pairs 是按照顺序排好序的 所有这儿可以直接比较
                    if (i > 0) {
                        Pair pre = keyPairs.get(i - 1);

                        // 差一个
                        if (pre.end + 2 == p.start) {
                            res = Math.max(res, p.end - p.start + 1 + pre.end - pre.start + 1 + (keyPairs.size() >= 3 ? 1 : 0));
                        }
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}