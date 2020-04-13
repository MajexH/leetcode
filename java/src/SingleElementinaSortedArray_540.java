public class SingleElementinaSortedArray_540 {

    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            // 越界
            // 因为只有一个single 其他 twice
            if (mid % 2 == 0) {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    i = mid + 2;
                } else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    j = mid - 2;
                } else {
                    return nums[mid];
                }
            } else {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    j = mid - 1;
                } else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    i = mid + 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new SingleElementinaSortedArray_540().singleNonDuplicate(new int[]{ 1 }));
    }
}
