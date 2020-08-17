package chapter6;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence_57_1 {

    public int[][] findContinuousSequence(int target) {
        // 因为最少这个数组里面要两个数 因此计算到 target / 2 即可 因为在之后的数 无论哪两个加起来 都会超过 target
        int min = 1, max = 2;
        List<List<Integer>> res = new ArrayList<>();
        while (min < (target + 1) / 2) {
            int sum = ((min + max) * (max - min + 1)) / 2;
            while (sum > target && min < max) {
                sum -= min;
                min++;
            }
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                for (int i = min; i <= max; i++) {
                    temp.add(i);
                }
                res.add(temp);
            }
            max++;
        }
        int[][] returnV = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            returnV[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                returnV[i][j] = res.get(i).get(j);
            }
        }
        return returnV;
    }
}
