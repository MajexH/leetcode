package array;

/**
 * @author majexh
 */
public class SearchInRotatedNew {

    /**
     * 只有一次 rotated 的
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > nums[j]) {
                    // 拐点在自己或者右边
                    if (target > nums[mid] || target < nums[i]) {
                        i = mid + 1;
                    } else {
                        j = mid - 1;
                    }
                } else if (nums[mid] < nums[i]) {
                    // 拐点是自己或者左边
                    if (target < nums[mid] || target > nums[j]) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                } else {
                    // 正常的二分
                    if (target > nums[mid]) {
                        i = mid + 1;
                    } else {
                        j = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedNew().search(new int[]{ 4,5,6,7,0,1,2 }, 3));
    }
}
