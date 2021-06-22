package chapter2.findAndSort;

public class MinArray_11 {

    // 旋转一次之后的数组中的最小值
    // 有相等的数据
    public int minArray(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == nums[i] && nums[mid] == nums[j]) {
                int min = Integer.MAX_VALUE;
                while (i <= j) {
                    min = Math.min(min, nums[i]);
                    i++;
                }
                return min;
            }
            if (nums[mid] > nums[j]) {
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
