public class FindMinII_154 {

    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == nums[i] && nums[mid] == nums[j]) {
                int min = nums[i];
                while (i <= j) {
                    min = Math.min(min, nums[i++]);
                }
                return min;
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else if (nums[mid] < nums[i]) {
                j = mid;
            } else {
                return nums[i];
            }
        }
        return nums[i];
    }
}
