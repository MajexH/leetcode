package highFrequency.array;

public class NextPermutation {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    /**
     * 这道题是找出 nums 能够组成的字典序的 更大的下一个排列
     * 如果一个数组 [7,6,5,4,3] 是逆序排列的 那么他已经是一个字典序最大的了 因此需要反转这个数组
     * 如果一个数组是 [7,5,6,4,3] 5 6 明显形成了一个逆序 他的下一个大于它的字典排列其实是 交换 5 6 后
     * 然后将 5 4 3 反转
     * 为什么呢 因为一个完全逆序的数组 下一个字典序一定是整个数组全部逆序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 越界
        if (nums == null || nums.length == 0) return;

        int i = nums.length - 1;
        // 找到逆序点
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            i--;
        }
        // 整个是一个降序排列
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // 找到从 nums.length - 1 -> i 中第一个大于 nums[i - 1] 的数儿 交换
            // 然后反装 i 到末尾的数儿
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
            reverse(nums, i, nums.length - 1);
        }
    }
}
