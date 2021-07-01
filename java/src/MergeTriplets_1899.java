import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeTriplets_1899 {

    // 很简单 尽可能的合并即可
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[target.length];

        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                res[0] = Math.max(res[0], triplet[0]);
                res[1] = Math.max(res[1], triplet[1]);
                res[2] = Math.max(res[2], triplet[2]);
            }
        }
        boolean flag = true;
        for (int i = 0; i < target.length; i++) {
            flag = flag && (target[i] == res[i]);
        }
        return flag;
    }


    // 找到交集
    public boolean mergeTripletsWithSubsets(int[][] triplets, int[] target) {
        List<Set<Integer>> selectedIndexes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            selectedIndexes.add(new HashSet<>());
        }
        // 是否有数字能够达到 target
        boolean[] reachTarget = new boolean[3];
        for (int i = 0; i < triplets.length; i++) {
            int[] triplet = triplets[i];
            for (int j = 0; j < triplet.length; j++) {
                if (triplet[j] <= target[j]) {
                    selectedIndexes.get(j).add(i);
                }
                if (triplet[j] == target[j]) reachTarget[j] = true;
            }
        }
        if (!(reachTarget[0] && reachTarget[1] && reachTarget[2])) return false;

        // 找到 selectedIndexes 里面的交集的部分 如果没有交集 说明没有结果
        int[] merged = new int[3];
        int select = 0;
        for (int i = 1; i < 3; i++) {
            if (selectedIndexes.get(i).size() > selectedIndexes.get(select).size()) {
                select = i;
            }
        }
        int other, another;
        if (select == 0) {
            other = 1;
            another = 2;
        } else if (select == 1) {
            other = 0;
            another = 2;
        } else {
            other = 0;
            another = 1;
        }

        for (int one : selectedIndexes.get(select)) {
            if (selectedIndexes.get(other).contains(one) && selectedIndexes.get(another).contains(one)) {
                for (int i = 0; i < 3; i++) {
                    merged[i] = Math.max(merged[i], triplets[one][i]);
                }
            }
        }
        boolean res = true;
        for (int i = 0; i < 3; i++) {
            res = res && (merged[i] == target[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MergeTriplets_1899().mergeTriplets(new int[][]{
                {2, 5, 3},
                {1, 8, 4},
                {1, 7, 5}
        }, new int[]{2, 7, 5}));
    }
}
