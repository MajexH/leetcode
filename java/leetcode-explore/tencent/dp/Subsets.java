package tencent.dp;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), 0, nums);
        return res;
    }

    public void recursion(List<List<Integer>> res, List<Integer> tmp, int start, int[] nums) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            recursion(res, tmp, i + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
