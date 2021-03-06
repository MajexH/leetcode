import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PDDInterview2 {

    public void recursion(Set<Integer> res, List<Integer> coins, int index, int sum) {
        if (sum != 0) res.add(sum);
        for (int i = index; i < coins.size(); i++) {
            sum += coins.get(i);
            recursion(res, coins, i + 1, sum);
            sum -= coins.get(i);
        }
    }

    /**
     * 给定一个硬币数组 coins 表示硬币的面额
     * 给定一个硬币的数量数组 counts 表示每种硬币的数量
     * 返回一个能够形成的面额的数量
     * @param coins
     * @param counts
     * @return
     */
    public List<Integer> getPermutation(int[] coins, int[] counts) {
        Set<Integer> res = new HashSet<>();
        List<Integer> coinsWithCount = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                coinsWithCount.add(coins[i]);
            }
        }
        recursion(res, coinsWithCount,0, 0);
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new PDDInterview2().getPermutation(new int[]{1,4}, new int[]{2,2}));
    }
}
