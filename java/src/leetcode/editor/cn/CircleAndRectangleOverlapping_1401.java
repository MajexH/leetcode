//给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1
//) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。 
//
// 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。 
//
// 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。 
//
// 
//
// 示例 1 ： 
// 
// 
//输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
//输出：true
//解释：圆和矩形存在公共点 (1,0) 。
// 
//
// 示例 2 ： 
//
// 
//输入：radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
//输出：false
// 
//
// 示例 3 ： 
// 
// 
//输入：radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= radius <= 2000 
// -10⁴ <= xCenter, yCenter <= 10⁴ 
// -10⁴ <= x1 < x2 <= 10⁴ 
// -10⁴ <= y1 < y2 <= 10⁴ 
// 
//
// Related Topics 几何 数学 👍 60 👎 0


package src.leetcode.editor.cn;

public class CircleAndRectangleOverlapping_1401 {
    public static void main(String[] args) {
        Solution solution = new CircleAndRectangleOverlapping_1401().new Solution();
        System.out.println(solution.checkOverlap(4, 102, 50, 0, 0, 100, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

            // 圆心在矩形中
            if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
                return true;
            }

            // 圆心在横坐标的范围内
            // 圆心在矩形上面
            if (xCenter >= x1 && xCenter <= x2 && yCenter >= y2 && (yCenter - y2) <= radius) {
                return true;
            }
            // 圆心在矩形下面
            if (xCenter >= x1 && xCenter <= x2 && yCenter <= y1 && (y1 - yCenter) <= radius) {
                return true;
            }

            // 圆心在 y 左边范围内
            // 圆心在左边
            if (yCenter >= y1 && yCenter <= y2 && xCenter <= x1 && (x1 - xCenter) <= radius) {
                return true;
            }
            // 圆心在右边
            if (yCenter >= y1 && yCenter <= y2 && xCenter >= x2 && (xCenter - x2) <= radius) {
                return true;
            }

            // 圆心在四个角
            if (this.pointInCircle(radius, xCenter, yCenter, x1, y1) ||
                    this.pointInCircle(radius, xCenter, yCenter, x1, y2) ||
                    this.pointInCircle(radius, xCenter, yCenter, x2, y1) ||
                    this.pointInCircle(radius, xCenter, yCenter, x2, y2)) {
                return true;
            }

            return false;
        }

        private boolean pointInCircle(int radius, int xCenter, int yCenter, int x, int y) {
            return (Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2)) <= radius * radius;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}