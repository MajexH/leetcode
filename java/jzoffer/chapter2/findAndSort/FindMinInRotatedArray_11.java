package chapter2.findAndSort;

public class FindMinInRotatedArray_11 {

    public int findMinInRotated(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] == nums[i] && nums[mid] == nums[j]) {
                int min = Integer.MAX_VALUE;
                while (i <= j) {
                    min = Math.min(nums[i], min);
                    i++;
                }
                return min;
            }
            // 说明拐点在右边
            else if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else if (nums[mid] < nums[i]) {
            // 说明拐点在左边或者自己
                j = mid;
            } else {
                // 正常的二分
                return nums[i];
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinInRotatedArray_11().findMinInRotated(new int[]{3,3,1,3}));
    }
}
