package leetcode.editor.cn;//给你个整数数组 arr，其中每个元素都 不相同。
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,2,1,3]
//输出：[[1,2],[2,3],[3,4]]
// 
//
// 示例 2： 
//
// 输入：arr = [1,3,6,10,15]
//输出：[[1,3]]
// 
//
// 示例 3： 
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
//输出：[[-14,-10],[19,23],[23,27]]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 10^5 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 数组 排序 👍 105 👎 0


import java.util.*;

public class MinimumAbsoluteDifference1200 {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifference1200().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);

            int miniDiff = Integer.MAX_VALUE;
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];

                if (miniDiff > diff) {
                    res = new ArrayList<>();
                    res.add(Arrays.asList(arr[i], arr[i + 1]));
                    miniDiff = diff;
                } else if (miniDiff == diff) {
                    res.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }

            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}