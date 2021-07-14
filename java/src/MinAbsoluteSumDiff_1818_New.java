import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinAbsoluteSumDiff_1818_New {

    private static final int MOD = 1000000007;

    // [1,28,21] [9,21,20] 这种结果没办法做出来 用原来的思路的话
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int[] cpNums1 = new int[nums1.length];
        System.arraycopy(nums1, 0, cpNums1, 0, nums1.length);
        // 方便查找
        Arrays.sort(cpNums1);
        // sum 为最后的结果 maxN 为 |nums1[i] - nums2[i]| - |nums1[j] - nums2[i]| 的最大值
        int sum = 0, maxN = 0;

        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;

            int j = binarySearch(cpNums1, nums2[i]);
            // 里的最近的 左右都比较
            if (j < nums1.length) {
                maxN = Math.max(maxN, diff - (cpNums1[j] - nums2[i]));
            }
            if (j > 0) {
                maxN = Math.max(maxN, diff - (nums2[i] - cpNums1[j - 1]));
            }
        }

        return (sum - maxN + MOD) % MOD;
    }

    public int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        if (target > nums[j]) return j + 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
