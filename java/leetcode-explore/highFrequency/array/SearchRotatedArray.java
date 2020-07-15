package highFrequency.array;

public class SearchRotatedArray {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] > nums[j]) {
                // 拐点在右边
                if (target < nums[i] || target > nums[mid]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else if (nums[mid] < nums[i]) {
                // 拐点在左边
                if (target > nums[j] || target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                // 正常的二分
                if (nums[mid] > target) {
                    j = mid - 1;
                } else if (nums[mid] < target) {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchRotatedArray().search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
