package CombinationSum39;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    public void recursion(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start) {
        if (target < 0) {
            return;
        }
        if (0 == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            recursion(candidates, target - candidates[i], res, temp, i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,5}, 8));
    }
}
