//给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
//
// 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。 
//
// 满足条件的二叉树一共有多少个？答案可能很大，返回 对 10⁹ + 7 取余 的结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [2, 4]
//输出: 3
//解释: 可以得到这些二叉树: [2], [4], [4, 2, 2] 
//
// 示例 2: 
//
// 
//输入: arr = [2, 4, 5, 10]
//输出: 7
//解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]. 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 2 <= arr[i] <= 10⁹ 
// arr 中的所有值 互不相同 
// 
//
// Related Topics 数组 哈希表 动态规划 排序 👍 147 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class BinaryTreesWithFactors_823 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreesWithFactors_823().new Solution();
        System.out.println(solution.numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(solution.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFactoredBinaryTrees(int[] arr) {

            if (Objects.isNull(arr) || arr.length == 0) {
                return 0;
            }

            long res = 0, mod = 1000000007;

            // 从小大到大排序是一定需要的 这样可以保证 选择当前节点的时候 子节点一定在之前的位置选取
            Arrays.sort(arr);

            // 表示 以 arr[1] 结尾数据有多少种
            long[] dp = new long[arr.length];
            // 以自己结尾的肯定有自己单独一个节点
            Arrays.fill(dp, 1L);

            for (int i = 0; i < arr.length; i++) {
                int left = 0, right = i - 1;
                while (left <= right) {
                    // 如果两个乘起来大于了 说明要减小
                    long mul = (long) arr[left] * arr[right];
                    if (mul > arr[i]) {
                        right--;
                    } else if (mul < arr[i]) {
                        left++;
                    } else {
                        // 这种情况就是相等 说明可以形成对应的节点
                        if (left == right) {
                            // 说明这个时候 两个已经是同一个节点
                            dp[i] += dp[left] * dp[right];
                        } else {
                            dp[i] += 2 * (dp[left] * dp[right]);
                        }
                        left++;
                    }
                }
                res = (res + dp[i]) % mod;
            }

            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}