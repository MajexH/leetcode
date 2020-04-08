import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(k, n, new ArrayList<>(), res, 1);
        return res;
    }

    public void recursion(int k, int n, List<Integer> temp, List<List<Integer>> res, int index) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            temp.add(i);
            recursion(k - 1, n - i, temp, res, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIII_216().combinationSum3(3, 9));
    }
}
