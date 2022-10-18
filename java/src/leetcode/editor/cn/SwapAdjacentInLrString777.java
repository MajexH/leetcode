//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回
//True。 
//
// 
//
// 示例 : 
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(start) = len(end) <= 10000。 
// start和end中的字符串仅限于'L', 'R'和'X'。 
// 
//
// Related Topics 双指针 字符串 👍 214 👎 0


package leetcode.editor.cn;

public class SwapAdjacentInLrString777 {
    public static void main(String[] args) {
        Solution solution = new SwapAdjacentInLrString777().new Solution();
        System.out.println(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(solution.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
        System.out.println(solution.canTransform("XLXRRXXRXX", "LXXXXXXRRR"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // XL --> LX L 可以在x向左移动
        // RX --> XR R 可以在x向右移动
        public boolean canTransform(String start, String end) {

            char[] startChars = start.toCharArray();
            char[] endChars = end.toCharArray();

            for (int i = 0, j = 0; i < startChars.length && j < endChars.length; ) {
                // 如果 相等 那么就跳过
                if (startChars[i] == endChars[j]) {
                    i++;
                    j++;
                    continue;
                }
                // 不等 但是又是最后一个了 直接返回 false
                if (i == startChars.length - 1) {
                    return false;
                }
                // 如果不等 只有两种情况才是可以的
                // 剩下的直接返回 false
                if (startChars[i] == 'R' && endChars[j] == 'X') {
                    // 从 end 出发向右寻找到第一个为 R 的 然后交换 end chars
                    // 因为从左向右遍历 必须保证从向左交换

                    int t = j;
                    while (t < endChars.length && endChars[t] == 'X') {
                        t++;
                    }
                    // 然后交换 不然认为不行
                    // 这种时候 start 的下一个是 X 可以交换向下匹配
                    if (t == endChars.length || endChars[t] != 'R') {
                        return false;
                    }
                    swap(endChars, j, t);
                    continue;
                }
                if (startChars[i] == 'X' && endChars[j] == 'L') {
                    // 找到下一个为 L 的地方 不然认为不行
                    int t = i;
                    while (t < startChars.length && startChars[t] == 'X') {
                        t++;
                    }
                    if (t == startChars.length || startChars[t] != 'L') {
                        return false;
                    }
                    swap(startChars, i, t);
                    continue;
                }
                return false;
            }

            return true;
        }

        private void swap(char[] chars, int i, int j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}