import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {

    // candidates 中数字只能使用一次
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void recursion(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int start, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (can(candidates, start, i)) {
                tmp.add(candidates[i]);
                recursion(res, tmp, candidates, i + 1, target - candidates[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean can(int[] candidates, int i, int j) {
        while (i < j) {
            if (candidates[i++] == candidates[j]) return false;
        }
        return true;
    }
}
