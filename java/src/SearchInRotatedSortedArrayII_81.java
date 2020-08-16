public class SearchInRotatedSortedArrayII_81 {

    // 在一个旋转排序数组里面查找目标值
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) return true;
            else {
                if (nums[mid] == nums[i] && nums[mid] == nums[j]) {
                    // 只能顺序查找
                    while (i <= j) {
                        if (nums[i] == target) return true;
                        i++;
                    }
                    // 没找到
                    return false;
                }
                // 说明拐点在自己或者左边
                else if (nums[mid] < nums[i]) {
                    if (target > nums[j] || target < nums[mid]) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                } else if (nums[mid] > nums[j]) {
                    // 拐点在右边
                    if (target > nums[mid] || target < nums[i]) {
                        i = mid + 1;
                    } else {
                        j = mid - 1;
                    }
                } else {
                    // 正常的二分
                    if (nums[mid] > target) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                }
            }
        }
        return nums[i] == target;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArrayII_81().search(new int[]{3,1}, 1));
    }
}
