import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public void recursion(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        if (temp.size() >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            recursion(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Subsets_78().subsets(new int[]{1,2,3}));
    }
}
