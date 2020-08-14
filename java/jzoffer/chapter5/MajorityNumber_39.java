package chapter5;

public class MajorityNumber_39 {

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i < nums.length && base > nums[i]) if (i == end) break;
            while (--j >= 0 && base < nums[j]) if (j == start) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    // 因为是找里面出现查过一半的数字 那么排序后 如果出现在 mid 位置的 就一定是这个出现超过一半的数字
    // 而又不需要整体的排序，只需要知道 在mid 这个位置的数字是谁 因此直接 用 快拍的 partition 即可
    public int majorityElement1(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;
        int index = partition(nums, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[mid];
    }

    // 这个找的思想基于一种抵消的思想，如果一个数字超过一半
    // 那么这个数字和其他的两两抵消 剩下的最后一定是这个数字
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int counter = 1, num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                counter++;
            } else if (counter == 0) {
                // 这个地方相当于抵消完了
                num = nums[i];
                counter = 1;
            } else {
                // 还未抵消完
                counter--;
            }
        }
        return num;
    }
}
