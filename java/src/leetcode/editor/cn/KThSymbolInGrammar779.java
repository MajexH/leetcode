//我们构建了一个包含 n 行( 索引从 1 开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。 
//
// 
// 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。 
// 
//
// 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始） 
//
// 示例 1: 
//
// 
//输入: n = 1, k = 1
//输出: 0
//解释: 第一行：0
// 
//
// 示例 2: 
//
// 
//输入: n = 2, k = 1
//输出: 0
//解释: 
//第一行: 0 
//第二行: 01
// 
//
// 示例 3: 
//
// 
//输入: n = 2, k = 2
//输出: 1
//解释:
//第一行: 0
//第二行: 01
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 30 
// 1 <= k <= 2n - 1 
// 
//
// Related Topics 位运算 递归 数学 👍 242 👎 0


package leetcode.editor.cn;

public class KThSymbolInGrammar779 {
    public static void main(String[] args) {
        Solution solution = new KThSymbolInGrammar779().new Solution();
        System.out.println(solution.kthGrammar(1, 1));
        System.out.println(solution.kthGrammar(2, 1));
        System.out.println(solution.kthGrammar(2, 2));
        System.out.println(solution.kthGrammar(5, 3));
        System.out.println(solution.kthGrammar(5, 13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int kthGrammar(int n, int k) {
            // 本来这种情况是不存在的
            if (k > Math.pow(2D, n - 1D)) {
                return -1;
            }

            return this.recursion(n, k, true);
        }

        public int recursion(int n, int k, boolean same) {
            if (n == 1) {
                return same ? 0 : 1;
            }

            int previous = (int) Math.pow(2D, n - 2D);

            // 当前层跟上一层是否一样
            // 下一层等当前层是相反的 即 same == false 那么下一层和当前层与上一层是相反的关系
            // 下一层跟当前是相同的 即 same == true 那么下一层和当前层与上一层的关系相同
            boolean previousSame = k <= previous;

            return recursion(n - 1, k > previous ? k - previous : k, same == previousSame);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}