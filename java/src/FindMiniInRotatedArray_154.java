public class FindMiniInRotatedArray_154 {

    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;

            if (nums[i] == nums[mid] && nums[mid] == nums[j]) {
                int mini = Integer.MAX_VALUE;
                while (i <= j) {
                    mini = Math.min(mini, nums[i]);
                    i++;
                }
                return mini;
            } else if (nums[mid] > nums[j]) {
                // 拐点在右边
                i = mid + 1;
            } else if (nums[mid] < nums[i]) {
                // 拐点在左边
                j = mid;
            } else {
                // 正常的二分
                return nums[i];
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new FindMiniInRotatedArray_154().findMin(new int[]{2,2,2,0,1}));
    }
}
