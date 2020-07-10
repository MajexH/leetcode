import java.util.ArrayList;
import java.util.List;

public class CombinationSumIIINew_216 {

    public void recursion(int k, int n, List<List<Integer>> res, List<Integer> temp, int start) {
        if (k == 0) {
            if (n == 0) res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            recursion(k - 1, n - i, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(k, n, res, new ArrayList<>(), 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIIINew_216().combinationSum3(3, 9));
    }
}
