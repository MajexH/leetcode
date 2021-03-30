import java.util.Arrays;

public class ClosestCost_1774 {

    int res = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = Integer.MAX_VALUE;

        for (int base : baseCosts) {
            recursion(0, base, target, toppingCosts);
        }
        return res;
    }

    public void recursion(int index, int cur, int target, int[] toppingCosts) {
        // 更新 选择离 target 更近的 或者 更小的
        if (Math.abs(cur - target) < Math.abs(res - target) || (Math.abs(cur - target) == Math.abs(res - target) && cur < res)) {
            // 需要选择更小的
            res = cur;
        }
        // 越界不可能
        if (cur >= target || index >= toppingCosts.length) {
            return;
        }

        recursion(index + 1, cur, target, toppingCosts);
        recursion(index + 1, cur + toppingCosts[index], target, toppingCosts);
        recursion(index + 1, cur + 2 * toppingCosts[index], target, toppingCosts);
    }
}
