package google;

public class KthSlots {

    /**
     * 花园里有 N 个花盆，每个花盆里都有一朵花。这 N 朵花会在 N 天内依次开放，每天有且仅有一朵花会开放并且会一直盛开下去。
     *
     * 给定一个数组 flowers 包含从 1 到 N 的数字，每个数字表示在那一天开放的花所在的花盆编号。
     *
     *
     * 例如，
     * flowers[i] = x 表示在第 i+1 天盛开的花在第 x 个花盆中，i 和 x 都在 1 到 N 的范围内。
     *
     * 给你一个整数 k，请你输出在哪一天恰好有两朵盛开的花，他们中间间隔了 k 朵花并且都没有开放。
     *
     * 如果不存在，输出 -1。
     *
     * 这道题的意思是 这个隔了 K 朵花的间隔 中间没有一朵花是开的
     * 因此用滑动窗口即可 这个滑动窗口的大小是 k + 2 (因为要让这个K的间隔是没有花开的 然后 最左和最右 分别表示开了的话 而中间的K个是没有花开的 就表示可以了)
     *
     * @param bulbs 表示在哪一天那朵花开
     * @param K 表示隔了多少朵花
     * @return
     */
    public int kEmptySlots(int[] bulbs, int K) {
        // 滑动窗口过大
        if (bulbs.length < K + 2) return -1;
        // days 表示第 i 盆花会在哪一天开
        int[] days = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            // 因为 bulbs[] 取值实在 1 - N
            days[bulbs[i] - 1] = i + 1;
        }
        int res = Integer.MAX_VALUE;
        // 那么现在也就是说 一个 k + 2 的滑动窗口 如果中间的数都大于 最左 和 最右 说明是可以的
        // 因为现在 days 表示的是 花盆开花的时间 也就是说 如果 中间开花的时间都大于 左右两边的话 说明是可以的
        for (int left = 0, right = left + K + 1; right < days.length;) {
            boolean flag = false;
            for (int i = left + 1; i < right; i++) {
                // 如果中间开花的时间比两边小 说明不行
                if (days[i] < days[left] || days[i] < days[right]) {
                    // 这个时候更新下标 因为 i 可能是最小值 因此直接更新到 i
                    left = i;
                    right = i + K + 1;
                    flag = true;
                    break;
                }
            }
            // 说明中间没找到 直接进行下轮循环
            if (flag) continue;
            res = Math.min(res, Math.max(days[left], days[right]));
            // 这个时候找到了一组 需要重新定位 left right
            left = right;
            right = left + K + 1;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new KthSlots().kEmptySlots(new int[]{1,3,2}, 1));
    }
}
