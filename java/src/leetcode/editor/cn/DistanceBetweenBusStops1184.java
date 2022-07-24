//环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号
//为 (i + 1) % n 的车站之间的距离。 
//
// 环线上的公交车都可以按顺时针和逆时针的方向行驶。 
//
// 返回乘客从出发点 start 到目的地 destination 之间的最短距离。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 1
//输出：1
//解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 2
//输出：3
//解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：distance = [1,2,3,4], start = 0, destination = 3
//输出：4
//解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^4 
// distance.length == n 
// 0 <= start, destination < n 
// 0 <= distance[i] <= 10^4 
// 
//
// Related Topics 数组 👍 85 👎 0


package leetcode.editor.cn;

public class DistanceBetweenBusStops1184 {
    public static void main(String[] args) {
        Solution solution = new DistanceBetweenBusStops1184().new Solution();
        System.out.println(solution.distanceBetweenBusStops(new int[]{14, 13, 4, 7, 10, 17, 8, 3, 2, 13}, 2, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int travel1(int i, int[] distance, int destination) {
            if (i == destination) {
                return 0;
            }
            return distance[i] + this.travel1(i + 1 >= distance.length ? 0 : i + 1, distance, destination);
        }

        private int travel2(int i, int[] distance, int destination) {
            if (i == destination) {
                return 0;
            }
            int next = i - 1 < 0 ? distance.length - 1 : i - 1;
            return distance[next] + this.travel2(next, distance, destination);
        }

        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int timely = this.travel1(start, distance, destination);
            int reverse = this.travel2(start, distance, destination);
            return Math.min(timely, reverse);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}