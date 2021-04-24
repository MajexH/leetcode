import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void recursion(List<List<Integer>> res, List<Integer> tmp,int[] candidates, int start, int target) {
        if (start == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            recursion(res, tmp, candidates, i, target - candidates[i]);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
