//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 双指针 字符串 👍 112 👎 0


package leetcode.editor.cn;

public class MagicalString481 {
    public static void main(String[] args) {
        Solution solution = new MagicalString481().new Solution();
        System.out.println(solution.magicalString(1));
        System.out.println(solution.magicalString(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {

            if (n <= 3) {
                return 1;
            }

            StringBuilder originalStr = new StringBuilder("122");
            int originalIndex = 0;

            StringBuilder magicStr = new StringBuilder("12");

            for (; originalIndex <= n;) {
                // magic 的长度比 original 的小
                // 1. 把 original 长度比 magic 长度多的部分 append 到 magic 上
                int index = magicStr.length();
                magicStr.append(originalStr.substring(magicStr.length()));
                // 2. 从 magic 反向生成 original 的下一堆字符串
                String tmp = this.generate(originalStr.charAt(originalStr.length() - 1) == '1', index, magicStr);
                originalStr.append(tmp);
                originalIndex += tmp.length();
            }

            int res = 0;

            for (int i = 0; i < n; i++) {
                if (originalStr.charAt(i) == '1') {
                    res++;
                }
            }

            return res;
        }

        private String generate(boolean isOne, Integer index, StringBuilder magicStr) {
            StringBuilder builder = new StringBuilder();

            for (int i = index; i < magicStr.length(); i++) {
                char c = this.getChar(isOne);
                if (magicStr.charAt(i) == '1') {
                    builder.append(c);
                } else {
                    builder.append(c);
                    builder.append(c);
                }
                isOne = !isOne;
            }

            return builder.toString();
        }

        private char getChar(boolean isOne) {
            return isOne ? '2' : '1';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}