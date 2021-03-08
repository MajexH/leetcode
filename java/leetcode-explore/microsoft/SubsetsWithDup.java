package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursion(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void recursion(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<>(tmp));

        for (int i = start; i < nums.length; i++) {
            if (can(nums, start, i)) {
                tmp.add(nums[i]);
                recursion(res, tmp, nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean can(int[] nums, int i, int j) {
        while (i < j) {
            if (nums[i] == nums[j]) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1,2,2}));
    }
}
