import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates_90 {

    public void recursion(List<List<Integer>> res, List<Integer> temp, int[] nums, int index) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (can(nums, index, i)) {
                temp.add(nums[i]);
                recursion(res, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean can(int[] nums, int i, int j) {
        while (i < j) {
            if (nums[i++] == nums[j]) return false;
        }
        return true;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursion(res, new ArrayList<>(), nums, 0);
        return res;
    }
}
