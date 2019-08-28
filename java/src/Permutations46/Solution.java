package Permutations46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 全排列
public class Solution {

    /**
     * 交换nums数组上的两个数的值
     * @param nums
     * @param left
     * @param right
     */
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void swapList(List<Integer> nums, int left, int right) {
        int temp = nums.get(left);
        nums.set(left, nums.get(right));
        nums.set(right, temp);
    }

    public void recursion1(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            // 这样效率是十分低下的 所以把nums转换成list直接做就行了
            res.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            recursion1(nums, index + 1, res);
            // swap back
            swap(nums, i, index);
        }
    }

    public void recursion(List<Integer> nums, int index, List<List<Integer>> res) {
        if (index == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            swapList(nums, i, index);
            recursion(nums, index + 1, res);
            // swap back
            swapList(nums, i, index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        recursion(list, 0, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{ 1, 2, 3 }));
    }
}
