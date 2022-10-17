//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 308 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets904 {
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets904().new Solution();
        System.out.println(solution.totalFruit(new int[]{1, 2, 1}));
        System.out.println(solution.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {

            Map<Integer, Integer> window = new HashMap<>();

            int maxSize = 0;

            for (int left = 0, right = 0; right < fruits.length; right++) {
                // 添加数据
                window.put(fruits[right], window.getOrDefault(fruits[right], 0) + 1);

                while (window.size() > 2 && left < fruits.length) {
                    window.put(fruits[left], window.get(fruits[left]) - 1);
                    if (window.get(fruits[left]) == 0) {
                        window.remove(fruits[left]);
                    }
                    left++;
                }

                maxSize = Math.max(right - left + 1, maxSize);
            }

            return maxSize;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}