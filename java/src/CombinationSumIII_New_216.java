import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_New_216 {

    public void recursion(List<List<Integer>> res, List<Integer> temp, int k, int n, int index) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            temp.add(i);
            recursion(res, temp, k - 1, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), k, n, 1);
        return res;
    }
}
