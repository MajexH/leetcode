package chapter6;

public class TwoSum_57 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{ nums[left], nums[right] };
            }
        }
        return new int[]{-1,-1};
    }
}
