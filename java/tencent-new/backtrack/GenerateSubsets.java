package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {

    public void recursion(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        res.add(new ArrayList<>(temp));
        if (start >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            recursion(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(nums, res, new ArrayList<>(), 0);
        return res;
    }
}
