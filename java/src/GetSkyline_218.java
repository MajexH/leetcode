import java.util.*;

public class GetSkyline_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();

        // int[] 保存左坐标和高度
        // 并根据 高度进行排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            // 把坐标点的左右给加进去
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        // 从小到大 排序
        boundaries.sort(Comparator.comparingInt(a -> a));

        int idx = 0, n = buildings.length;
        for (int boundary : boundaries) {
            // 遍历左侧的所有的建筑
            while (idx < n && buildings[idx][0] <= boundary) {
                queue.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            // 找到其中的最大值
            while (!queue.isEmpty() && queue.peek()[0] <= boundary) {
                queue.poll();
            }

            int maxn = queue.isEmpty() ? 0 : queue.peek()[1];
            if (res.size() == 0 || maxn != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(boundary, maxn));
            }
        }
        return res;
    }
}
