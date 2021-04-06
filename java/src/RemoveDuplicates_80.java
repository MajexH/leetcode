public class RemoveDuplicates_80 {

    public int removeDuplicates(int[] nums) {
        // 删除排序数组的重复项 能够保留两个重复项

        // l、r 框定一个区域
        int l = 0, r = 0;
        // 最后返回结果的 index
        int newIndex = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] == nums[l]) {
                r++;
            }

            for (int i = 0; i < Math.min(2, r - l); i++) {
                nums[newIndex++] = nums[l];
            }
            l = r;
        }

        return newIndex;
    }
}
