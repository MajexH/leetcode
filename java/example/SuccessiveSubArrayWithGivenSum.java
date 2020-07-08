public class SuccessiveSubArrayWithGivenSum {

    /**
     * 给定一个无序的正数数组 nums，求 nums 的所有子数组中，
     * 所有元素之和为 target 的最长子数组的长度
     * 这儿要求的是 一个连续的子数组
     * @param nums
     * @param target
     * @return 连续子数组的最大长度
     */
    public int successiveSubArrayWithGivenSum(int[] nums, int target) {
        // 长度为 0 肯定是不存在的
        if (nums.length == 0) return 0;
        int last = 0, fast = 0;
        int maxLength = 1;
        int sum = nums[0];
        while (last <= fast) {
            if (sum < target) {
                fast++;
                if (fast >= nums.length) break;
                sum += nums[fast];
            } else if (sum > target) {
                last++;
                // 重新开始
                if (last >= fast) {
                    fast = last;
                    sum = nums[fast];
                } else {
                    sum -= nums[last];
                }
            } else {
                maxLength = Math.max(maxLength, fast - last + 1);
                sum -= nums[last];
                last++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new SuccessiveSubArrayWithGivenSum().successiveSubArrayWithGivenSum(new int[]{ 1,1,1,3,1 }, 3));
    }
}
