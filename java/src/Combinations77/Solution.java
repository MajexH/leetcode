package Combinations77;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    public void recursion(List<List<Integer>> res, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            recursion(res, temp, i + 1, n, k - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
