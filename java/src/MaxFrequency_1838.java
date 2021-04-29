import java.util.*;

public class MaxFrequency_1838 {

    private static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int maxFrequencyWithWindow(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        long window = 0;
        int res = 0;

        while (r < nums.length) {
            window += nums[r];
            while (l <= r && (long) nums[r] * (r - l + 1) - window > k) {
                window -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public int maxFrequency(int[] nums, int k) {

        List<Node> lists = new ArrayList<>();
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        for (int key : memo.keySet()) {
            lists.add(new Node(key, memo.get(key)));
        }
        lists.sort(Comparator.comparingInt(a -> a.num));

        int max = 1;
        // 这样就可以压缩 看可以遍历几个了
        // 这边是贪心的思想做的 就是让小于自己的数 去尝试++ 看最多能够得到多少的频率
        // 直接从离自己最近的开始 ++ 这样出来的结果 一定是最大的
        for (int i = 0; i < lists.size(); i++) {
            Node cur = lists.get(i);
            int tmpMax = cur.count, tmpK = k;
            for (int j = i - 1; j >= 0; j--) {
                Node pre = lists.get(j);
                // 这个一个数字变换过来的大小
                int t = cur.num - pre.num;
                if (tmpK < t) break;
                int min = Math.min(tmpK / t, pre.count);
                // 现在要看能把几个数字变换过来
                tmpMax += min;
                tmpK -= min * t;
            }
            max = Math.max(max, tmpMax);
        }

        return max;
    }

    public int maxFrequencyBruteForce(int[] nums, int k) {
        Arrays.sort(nums);

        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            int tmpMax = 1;
            int tmpK = k;
            for (int j = i - 1; j >= 0; j--) {
                int t = nums[i] - nums[j];
                if (tmpK < t) break;
                tmpK -= t;
                tmpMax++;
            }
            max = Math.max(tmpMax, max);
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new MaxFrequency_1838().maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(new MaxFrequency_1838().maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(new MaxFrequency_1838().maxFrequency(new int[]{3, 9, 6}, 2));
    }
}
