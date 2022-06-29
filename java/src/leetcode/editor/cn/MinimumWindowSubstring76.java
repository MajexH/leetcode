package leetcode.editor.cn;////给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
////
//// 
////
//// 注意： 
////
//// 
//// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//// 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "ADOBECODEBANC", t = "ABC"
////输出："BANC"
//// 
////
//// 示例 2： 
////
//// 
////输入：s = "a", t = "a"
////输出："a"
//// 
////
//// 示例 3: 
////
//// 
////输入: s = "a", t = "aa"
////输出: ""
////解释: t 中两个字符 'a' 均应包含在 s 的子串中，
////因此没有符合条件的子字符串，返回空字符串。 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= s.length, t.length <= 10⁵ 
//// s 和 t 由英文字母组成 
//// 
////
//// 
////进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1953 👎 0
//


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring76().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minWindow(String s, String t) {
            if (Objects.isNull(s) || Objects.isNull(t) || s.length() < t.length()) {
                return "";
            }

            String res = "";

            Map<Character, Integer> tMap = this.getStringMap(t);
            Map<Character, Integer> sMap = this.getStringMap(s.substring(0, t.length()));

            if (this.sContainsT(sMap, tMap)) {
                res = s.substring(0, t.length());
            }

            for (int left = 0, right = t.length(); right < s.length(); right++) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
                while (left <= right && this.sContainsT(sMap, tMap)) {
                    if (res.length() == 0 || res.length() > right - left + 1) {
                        res = s.substring(left, right + 1);
                    }
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                    if (sMap.get(s.charAt(left)) == 0) {
                        sMap.remove(s.charAt(left));
                    }
                    left++;
                }
            }

            return res;
        }

        private Map<Character, Integer> getStringMap(String s) {
            if (Objects.isNull(s) || s.length() == 0) {
                return new HashMap<>();
            }
            Map<Character, Integer> stringMap = new HashMap<>();

            for (char c : s.toCharArray()) {
                stringMap.put(c, stringMap.getOrDefault(c, 0) + 1);
            }

            return stringMap;
        }

        private boolean sContainsT(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {

            for (Map.Entry<Character, Integer> tEntry : tMap.entrySet()) {
                if (!sMap.containsKey(tEntry.getKey()) || tEntry.getValue() > sMap.get(tEntry.getKey())) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}