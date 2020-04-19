package array;

public class SearchInRotated {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
//            System.out.println(i + " " + j);
            int mid = (i + j) / 2;
            if (nums[mid] == target) return mid;
            // 说明拐点在右边
            else if (nums[mid] > nums[j]) {
                if (target == nums[j]) return j;
                // 说明要去右边找
                else if (target < nums[j] || target > nums[mid]) {
                    i = mid + 1;
                } else {
                    // 说明去左边
                    j = mid - 1;
                }
                // 说明拐点在左边
            } else if (nums[mid] < nums[i]){
                if (target == nums[j]) return j;
                // 说明去左边
                else if (target > nums[j] || target < nums[mid]) {
                    j = mid - 1;
                } else {
                    // 说明去右边
                    i = mid + 1;
                }
                // 正常的二分
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotated().search(new int[]{ 4,5,6,7,8,1,2,3 }, 8));
    }
}
