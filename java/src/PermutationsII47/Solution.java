package PermutationsII47;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void swapList(List<Integer> list, int left, int right) {
        int temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

    public boolean canSwap(List<Integer> list, int start, int end) {
        for (int i = start; i < end; i++) {
            if (list.get(i) == list.get(end)) {
                return false;
            }
        }
        return true;
    }

    public void recursion(List<Integer> nums, int index, List<List<Integer>> res) {
        if (index == nums.size() - 1) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            if (canSwap(nums, index, i)) {
                swapList(nums, index, i);
                recursion(nums, index + 1, res);
                swapList(nums, index, i);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        recursion(list, 0, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{ 1, 1, 2 }));
    }
}
