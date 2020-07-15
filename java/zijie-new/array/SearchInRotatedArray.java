package array;

import highFrequency.array.SearchRotatedArray;

public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[j]) {
                // 拐点在右边或者自己
                if (target > nums[mid] || target < nums[i]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else if (nums[mid] < nums[i]){
                // 拐点在左边或者自己
                if (target > nums[j] || target < nums[mid]) {
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
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
