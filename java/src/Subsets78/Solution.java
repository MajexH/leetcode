package Subsets78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(nums, 0, res, new LinkedList<>());
        return res;
    }

    public void recursion(int[] nums, int start, List<List<Integer>> res, LinkedList<Integer> temp) {
        res.add(new LinkedList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            recursion(nums, i + 1, res, temp);
            temp.removeLast();
        }
    }
}
