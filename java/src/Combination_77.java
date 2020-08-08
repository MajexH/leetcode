import java.util.ArrayList;
import java.util.List;

public class Combination_77 {

    public void recursion(List<List<Integer>> res, int n, int k, List<Integer> temp, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i >= 1; i--) {
            temp.add(i);
            recursion(res, n - 1, k - 1, temp, i - 1);
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, n, k, new ArrayList<>(), n);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Combination_77().combine(4, 2));
    }
}
