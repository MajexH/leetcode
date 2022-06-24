package leetcode.editor.cn;  //////给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//////
////// 算法的时间复杂度应该为 O(log (m+n)) 。 
//////
////// 
//////
////// 示例 1： 
//////
////// 
//////输入：nums1 = [1,3], nums2 = [2]
//////输出：2.00000
//////解释：合并数组 = [1,2,3] ，中位数 2
////// 
//////
////// 示例 2： 
//////
////// 
//////输入：nums1 = [1,2], nums2 = [3,4]
//////输出：2.50000
//////解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
////// 
//////
////// 
//////
////// 
//////
////// 提示： 
//////
////// 
////// nums1.length == m 
////// nums2.length == n 
////// 0 <= m <= 1000 
////// 0 <= n <= 1000 
////// 1 <= m + n <= 2000 
////// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
////// 
////// Related Topics 数组 二分查找 分治 👍 5534 👎 0
////
//


import java.util.Objects;

public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays4.Solution solution = new MedianOfTwoSortedArrays4().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3, 4}, new int[]{2, 5, 8}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{6, 7, 8}));
        System.out.println(solution.findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2,4}, new int[]{3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (Objects.isNull(nums1) || nums1.length == 0) {
                return this.findMedianSortedInOneArray(nums2);
            }
            if (Objects.isNull(nums2) || nums2.length == 0) {
                return this.findMedianSortedInOneArray(nums1);
            }

            // 两个游标
            int index1 = 0, index2 = 0;

            int totalLength = nums1.length + nums2.length;

            while (index1 < nums1.length || index2 < nums2.length) {

                // 停止条件
                if (index1 + index2 >= totalLength / 2) {
                    break;
                }

                if (index1 >= nums1.length) {
                    index2++;
                    continue;
                }
                if (index2 >= nums2.length) {
                    index1++;
                    continue;
                }

                int num1 = nums1[index1], num2 = nums2[index2];

                if (num1 < num2) {
                    index1++;
                } else {
                    index2++;
                }
            }

            if (index1 == nums1.length) {
                return ((totalLength & 1) == 1) ? nums2[index2] : (Math.max(index2 - 1 < 0 ? Integer.MIN_VALUE : nums2[index2 - 1], nums1[index1 - 1]) + nums2[index2]) / 2D;
            }

            if (index2 == nums2.length) {
                return ((totalLength & 1) == 1) ? nums1[index1] : (Math.max(index1 - 1 < 0 ? Integer.MIN_VALUE : nums1[index1 - 1], nums2[index2 - 1]) + nums1[index1]) / 2D;
            }


            if (nums1[index1] > nums2[index2]) {
                // 以 nums2 为最后一个
                return (totalLength & 1) == 1 ? nums2[index2] :
                        (nums2[index2] + Math.max(index1 - 1 < 0 ? Integer.MIN_VALUE : nums1[index1 - 1], index2 - 1 < 0 ? Integer.MIN_VALUE : nums2[index2 - 1])) / 2D;
            }

            return (totalLength & 1) == 1 ? nums1[index1] :
                    (nums1[index1] + Math.max(index2 - 1 < 0 ? Integer.MIN_VALUE : nums2[index2 - 1], index1 - 1 < 0 ? Integer.MIN_VALUE : nums1[index1 - 1])) / 2D;
        }

        private double findMedianSortedInOneArray(int[] nums) {
            if (Objects.isNull(nums) || nums.length == 0) {
                return 0D;
            }

            int len = nums.length;

            return len % 2 == 0 ? (nums[len / 2 - 1] + nums[len / 2]) / 2D : nums[len / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}