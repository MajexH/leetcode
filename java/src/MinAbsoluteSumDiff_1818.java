public class MinAbsoluteSumDiff_1818 {

    // 绝对差值和
    // 能够更改 nums1 中的一个数字成为 nums1 中的另一个数字
    // 是的 |nums1[i] - nums2[i]| 的总和最小
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int maxDiff = 0;
        int len = nums1.length;
        // 最大差值的下标
        int index = 0;
        // 找到最大的间隔
        for (int i = 0; i < len; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            if (maxDiff < abs) {
                maxDiff = abs;
                index = i;
            }
        }

        // index 就是要变幻的
        // 现在就需要知道 nums1 中 谁离 nums2[index] 最近
        // 然后进行变幻
        int change = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int abs = Math.abs(nums1[i] - nums2[index]);
            if (minDiff > abs) {
                minDiff = abs;
                change = i;
            }
        }

        nums1[index] = nums1[change];
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = (res + Math.abs(nums1[i] - nums2[i])) % 1000000007;
        }
        return res;
    }
}
