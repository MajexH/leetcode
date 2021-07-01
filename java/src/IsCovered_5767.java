import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IsCovered_5767 {

    // 判断 left -> right 的所有数 是不是都被 ranges 代表的区间覆盖了
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));

        List<int[]> stashedRanges = new ArrayList<>();
        for (int[] range : ranges) {
            // + 1 也是可以合并的
            if (stashedRanges.isEmpty() || stashedRanges.get(stashedRanges.size() - 1)[1] + 1< range[0]) {
                stashedRanges.add(range);
                continue;
            }
            int[] pre = stashedRanges.remove(stashedRanges.size() - 1);
            stashedRanges.add(new int[]{pre[0], Math.max(pre[1], range[1])});
        }

        for (int[] range : stashedRanges) {
            if (left >= range[0] && right <= range[1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsCovered_5767().isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
    }
}
