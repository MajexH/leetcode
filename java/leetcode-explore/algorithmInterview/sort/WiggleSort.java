package algorithmInterview.sort;

import java.util.Arrays;

public class WiggleSort {

    // 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序
    // 实际上是把数组分成两个部分 一个部分大 一个部分小 然后在组合起来
    public void wiggleSort(int[] nums) {
        int start = 0, end = nums.length - 1, mid = (start + end) / 2;
        int index = partition(nums, start, end);
        // 这样分离后 相当于已经将左边变成小于 右边的所有数
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        System.out.println(Arrays.toString(nums));
        // 因为可能存在中间 nums[mid] 一样的多个数 直接穿插可能会出现重复 因此 不看 中间的 相等的
        // 先排两侧不等的 odd 从左到右 even 从右到左
        // 这样最后相等的数 就只会排在数组的 最左和最右 是不可能会碰在一起的
        int odd = 1, even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (num > nums[mid]) {
                temp[odd] = num;
                odd += 2;
            } else if (num < nums[mid]) {
                temp[even] = num;
                even -= 2;
            }
        }
        while (odd < nums.length) {
            temp[odd] = nums[mid];
            odd += 2;
        }
        while (even >= 0) {
            temp[even] = nums[mid];
            even -= 2;
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i < nums.length && nums[i] < base) if (i == end) break;
            while (--j >= 0 && nums[j] > base) if (j == start) break;
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
    public static void main(String[] args) {
        new WiggleSort().wiggleSort(new int[]{5,3,1,2,6,7,8,5,5});
    }
}
