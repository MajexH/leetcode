import java.util.ArrayList;
import java.util.List;

public class CombinationSumNew_39 {

    // start 是为了避免重复
    // 因为一个数可以被重复使用，但是访问过了他 之后 后面的如果再用它 就会造成重复
    // 因此这儿直接 添加start 让下一个 recursion 从 当前的数 开始 查找排列
    public void recursion(List<List<Integer>> res, int[] candidates, int target, List<Integer> temp, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            recursion(res, candidates, target - candidates[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumNew_39().combinationSum(new int[]{2,3,5},8));
    }
}
