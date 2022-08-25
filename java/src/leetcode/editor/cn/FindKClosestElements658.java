//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 403 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindKClosestElements658 {
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements658().new Solution();
        System.out.println(solution.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            // 大顶堆 离得最远的 pop 出来
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
                int diffA = Math.abs(a - x), diffB = Math.abs(b - x);

                if (diffA != diffB) {
                    return diffB - diffA;
                }
                return b - a;
            });

            for (int num : arr) {
                priorityQueue.add(num);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }

            return priorityQueue.stream().sorted().collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}