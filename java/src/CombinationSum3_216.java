import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public void recursion(List<List<Integer>> res, List<Integer> tmp, int k, int n, int start) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            tmp.add(i);
            recursion(res, tmp, k - 1, n - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
