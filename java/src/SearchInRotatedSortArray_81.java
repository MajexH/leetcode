public class SearchInRotatedSortArray_81 {

    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return true;
            if (nums[i] == nums[mid] && nums[j] == nums[mid]) {
                while (i <= j) {
                    if (target == nums[i]) return true;
                    i++;
                }
                return false;
            } else if (nums[i] > nums[mid]) {
                // 拐点是 mid 或者左侧的某个数
                if (target > nums[j] || target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (nums[j] < nums[mid]) {
                // 拐点是 mid 或者右侧的某个数
                if (target > nums[mid] || target < nums[i]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }

        return nums[i] == target;
    }
}
