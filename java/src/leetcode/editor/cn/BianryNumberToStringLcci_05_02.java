//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
//
// Related Topics 位运算 数学 字符串 👍 115 👎 0


package leetcode.editor.cn;

public class BianryNumberToStringLcci_05_02 {
    public static void main(String[] args) {
        Solution solution = new BianryNumberToStringLcci_05_02().new Solution();
        System.out.println(solution.printBin(0.625));
        System.out.println(solution.printBin(0.1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String printBin(double num) {
            StringBuilder res = new StringBuilder("0.");

            double factor = 0.5;
            for (int i = 1; i <= 30; i++) {
                if (num - factor >= 0) {
                    res.append('1');
                    num -= factor;
                } else {
                    res.append('0');
                }

                if (num == 0) {
                    break;
                }

                factor *= 0.5;
            }

            return num == 0 ? res.toString() : "ERROR";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}