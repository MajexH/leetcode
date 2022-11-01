//我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。 
//
// 
// 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3
//,4] 和 nums2 =[5,6,7,8] 。 
// 
//
// 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。 
//
// 数组 arr 严格递增 且 arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。 
//
// 注意： 
//
// 
// 用例保证可以实现操作。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
//输出: 1
//解释: 
//交换 A[3] 和 B[3] 后，两个数组如下:
//A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
//两个数组均为严格递增的。 
//
// 示例 2: 
//
// 
//输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 2 * 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 375 👎 0


package leetcode.editor.cn;

public class MinimumSwapsToMakeSequencesIncreasing801 {
    public static void main(String[] args) {
        Solution solution = new MinimumSwapsToMakeSequencesIncreasing801().new Solution();

        System.out.println(solution.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwap(int[] nums1, int[] nums2) {

            // dp[i][0] 表示 i 这个位置不互换 那么需要的次数
            // dp[i][1] 表示 j 这个位置互换 需要的次数
            int[][] dp = new int[nums1.length][2];

            dp[0][0] = 0;
            dp[0][1] = 1;

            for (int i = 1; i < nums1.length; i++) {
                int nums1Pre = nums1[i - 1], nums1Current = nums1[i];
                int nums2Pre = nums2[i - 1], nums2Current = nums2[i];

                // 如果均比前面的大 那么交不交换意义不大 取最小即可
                if ((nums1Pre < nums1Current && nums2Pre < nums2Current)
                        && (nums1Pre < nums2Current && nums2Pre < nums1Current)) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    // 前面一个交不交换无所谓 取较小的一个
                    dp[i][1] = dp[i][0] + 1;
                } else if (nums1Pre < nums1Current && nums2Pre < nums2Current) {
                    // 相当于破坏了第二个条件 即当前是不能互换的 如果互换 那么前面一个也要互换
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    // 相当于破坏了前面所有的条件 即任意一个不递增 （两个不递增保证了不可能）
                    // 如果当前不互换 那么前一个必须要互换
                    dp[i][0] = dp[i - 1][1];
                    // 如果当前互换了 前一个必须不互换
                    dp[i][1] = dp[i - 1][0] + 1;
                }
            }

            return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}