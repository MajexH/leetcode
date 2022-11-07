//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
//
// Related Topics 字符串 回溯 👍 63 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates816 {
    public static void main(String[] args) {
        Solution solution = new AmbiguousCoordinates816().new Solution();
        System.out.println(solution.ambiguousCoordinates("(123)"));
        System.out.println(solution.ambiguousCoordinates("(00011)"));
        System.out.println(solution.ambiguousCoordinates("(0123)"));
        System.out.println(solution.ambiguousCoordinates("(100)"));
        System.out.println(solution.ambiguousCoordinates("(0010)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            s = s.substring(1, s.length() - 1);
            List<String> res = new ArrayList<>();


            for (int i = 0; i < s.length(); i++) {
                String left = s.substring(0, i + 1);
                String right = s.substring(i + 1);

                for (String l : this.dotSplit(left)) {
                    for (String r : this.dotSplit(right)) {
                        res.add(String.format("(%s, %s)", l, r));
                    }
                }
            }

            return res;
        }

        // . 分割
        private List<String> dotSplit(String s) {

            List<String> res = new ArrayList<>();

            // 遍历 , 存在的地方
            // 然后分别递归左右的数据
            for (int i = 0; i < s.length(); i++) {
                String left = s.substring(0, i + 1);
                String right = s.substring(i + 1);

                // left 可以单独为 0 但是 left 不能存在 0011 这种情况
                // 如果存在 left 那么 right 是可以有前道 0 的
                if ((left.length() > 0 && !isValidLeft(left))
                        || (right.length() > 0 && !isValidRight(right))) {
                    continue;
                }
                if (left.length() == 0) {
                    res.add(right);
                } else if (right.length() == 0) {
                    res.add(left);
                } else {
                    res.add(String.format("%s.%s", left, right));
                }
            }

            return res;
        }

        // 左边 0 只有有 1 位长度
        private boolean isValidLeft(String s) {
            if (s.length() == 1 && s.charAt(0) == '0') {
                return true;
            }

            // 或者前面有不是 0 的 那就就可以返回 true 了
            boolean zeroStart = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    zeroStart = false;
                }
                if (s.charAt(i) == '0' && zeroStart) {
                    return false;
                }
            }

            return true;
        }

        // 右边不用看左边是什么 全是 0 也是不可以的
        // 10 如果有后缀 0 也是不可以的
        // 从后向前 全是 0 也是不可以的
        private boolean isValidRight(String s) {



            boolean allZero = true;
            for (int i = s.length() - 1; i >= 0; i--) {

                // 10 不行
                if (allZero && s.charAt(i) != '0' && i < s.length() - 1) {
                    return false;
                }

                if (s.charAt(i) != '0') {
                    allZero = false;
                }
            }

            return !allZero;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}