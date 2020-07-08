public class FindMinInRotatedArray_11 {

    /**
     * 从一个旋转了一次的排序数组里面找出里面的最小值
     * 如 [3,4,5,1,2] 最小值为 1
     * @param nums 一个旋转了一个点的数组
     * @return 返回这个数组中的最小值
     */
    public int findMinInRotatedArray(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[i] > nums[mid]) {
                j = mid;
            } else if (nums[j] < nums[mid]) {
                i = mid + 1;
            } else {
                return nums[i];
            }
        }
        return Math.min(nums[i], nums[j]);
    }

    public static void main(String[] args) {
        System.out.println(new FindMinInRotatedArray_11().findMinInRotatedArray(new int[]{ 4,5,6,7,0,1,2 }));
    }
}
