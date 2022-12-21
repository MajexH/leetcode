//你正在玩一个单人游戏，面前放置着大小分别为 a、b 和 c 的 三堆 石子。 
//
// 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。 
//
// 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。 
//
// 示例 1： 
//
// 
//输入：a = 2, b = 4, c = 6
//输出：6
//解释：石子起始状态是 (2, 4, 6) ，最优的一组操作是：
//- 从第一和第三堆取，石子状态现在是 (1, 4, 5)
//- 从第一和第三堆取，石子状态现在是 (0, 4, 4)
//- 从第二和第三堆取，石子状态现在是 (0, 3, 3)
//- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
//- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
//- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
//总分：6 分 。
// 
//
// 示例 2： 
//
// 
//输入：a = 4, b = 4, c = 6
//输出：7
//解释：石子起始状态是 (4, 4, 6) ，最优的一组操作是：
//- 从第一和第二堆取，石子状态现在是 (3, 3, 6)
//- 从第一和第三堆取，石子状态现在是 (2, 3, 5)
//- 从第一和第三堆取，石子状态现在是 (1, 3, 4)
//- 从第一和第三堆取，石子状态现在是 (0, 3, 3)
//- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
//- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
//- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
//总分：7 分 。
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = 8, c = 8
//输出：8
//解释：最优的一组操作是连续从第二和第三堆取 8 回合，直到将它们取空。
//注意，由于第二和第三堆已经空了，游戏结束，不能继续从第一堆中取石子。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b, c <= 10⁵ 
// 
//
// Related Topics 贪心 数学 堆（优先队列） 👍 55 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones1753 {
    public static void main(String[] args) {
        Solution solution = new MaximumScoreFromRemovingStones1753().new Solution();
//        System.out.println(solution.maximumScore(4, 4, 6));
        System.out.println(solution.maximumScore(1, 8, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumScore(int a, int b, int c) {
            // 由于匹配
            // 1. a + b <= c 那么最多匹配 a + b 次
            // 2. a + b > c 那么相当于 a b 要多次匹配直到 a + b <= c 那么久可以执行第一个分支的内容了

            int[] array = new int[]{a, b, c};
            Arrays.sort(array);

            int res = 0;

            if (array[0] + array[1] > array[2]) {
                int diff = (int) Math.ceil((array[0] + array[1] - array[2]) / 2D);
                array[0] -= diff;
                array[1] -= diff;
                res += diff;
            }

            return res + array[0] + array[1];
        }

        public int maximumScoreWithPQ(int a, int b, int c) {

            // 大顶堆
            PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> j - i);

            if (a > 0) {
                queue.add(a);
            }
            if (b > 0) {
                queue.add(b);
            }
            if (c > 0) {
                queue.add(c);
            }

            int res = 0;
            while (queue.size() > 1) {
                int i = queue.poll(), j = queue.poll();
                i--;
                j--;
                res++;

                if (i > 0) {
                    queue.add(i);
                }
                if (j > 0) {
                    queue.add(j);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}