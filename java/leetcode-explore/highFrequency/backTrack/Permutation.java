package highFrequency.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, nums, 0);
        return res;
    }

    public void recursion(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            recursion(res, nums, start + 1);
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
