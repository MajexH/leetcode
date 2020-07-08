public class FindMinInRotatedArrayWithDuplicate {

    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        int mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
            // 都相等的时候 是无法判断拐点在哪儿的 因此只能顺序查找
            if (nums[mid] == nums[i] && nums[mid] == nums[j]) {
                int min = nums[i];
                for (int z = i + 1; z <= j; z++) {
                    min = Math.min(min, nums[z]);
                }
                return min;
            }
            else if (nums[mid] > nums[j]) {
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
