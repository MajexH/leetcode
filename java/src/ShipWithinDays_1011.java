import java.util.Arrays;

public class ShipWithinDays_1011 {

    // 把数组平均分成D份 而且每一份是连续的 问其中形成的和的最大值的最小值
    public int shipWithinDays(int[] weights, int D) {
        // 二分查找
        if (weights == null || weights.length == 0) return 0;
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).reduce(Integer::sum).getAsInt();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canGenerate(weights, D, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean canGenerate(int[] weights, int D, int mid) {
        int curWeight = 0, curSplit = 1;

        for (int weight : weights) {
            if (curWeight + weight > mid) {
                curWeight = 0;
                curSplit++;
            }
            curWeight += weight;
        }

        return curSplit <= D;
    }
}
