package PascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    List<Integer> list = res.get(i - 1);
                    temp.add(list.get(j - 1) + list.get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
