import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MaximumGap_164 {

    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        int n = nums.length;
        int max = nums[0];
        //找出最大的数字
        for (int i = 1; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int m = max;
        int exp = 1;
        //一位一位的进行
        while (max > 0) {
            //将之前的元素清空
            for (int i = 0; i < 10; i++) {
                lists.set(i, new ArrayList<>());
            }
            //将数字放入对应的位置
            for (int i = 0; i < n; i++) {
                lists.get(nums[i] / exp % 10).add(nums[i]);
            }

            //将数字依次拿出来
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    nums[index] = lists.get(i).get(j);
                    index++;
                }

            }
            max /= 10;
            exp *= 10;
        }

        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > maxGap) {
                maxGap = nums[i + 1] - nums[i];
            }
        }
        return maxGap;
    }

    // 基于比较排序的话 肯定最后的结果 都是要互相比较的
    // 最好的记过
    public int maximumGap2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        // 先求最大最小值
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 使用计数排序的思想，找到每个位置上有多少个数
        int[] counts = new int[max - min + 1];

        for (int num : nums) {
            counts[num - min]++;
        }

        // 根据每个位置上的数 去找到 相邻位置相差最大的
        int pre = -1;
        int res = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                if (pre != -1) {
                    res = Math.max(res, i - pre);
                }
                pre = i;
            }
        }
        return res;
    }



    // 这是直接用排序做的 时间复杂度是 o(nlogn)
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);

        int maxGap = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }

        return maxGap;
    }
}
