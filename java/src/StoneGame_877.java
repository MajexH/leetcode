import java.util.Arrays;
import java.util.LinkedList;

public class StoneGame_877 {

    // 动态规划就是用来剪枝的
    public boolean stoneGame(int[] piles) {
        // dp[i][j] 表示 取完 i -> j 的 pile 后 alix 剩下的最大值
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                // 比较选择 i 或者 选择 j 之后 哪个的值更大
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][piles.length - 1] > 0;
    }

    // 形成一个二叉树 不停地遍历结果即可 超时
    // 递归重复的地方是 前一轮 不管从哪儿开始取 那么一定一定下一轮的开始状态是一致的
    // 比如数组 [0,1,2,3] 表示其下标 第一轮取了 0 3 那么不管谁取了 0 或者 3
    // 下一轮一定是 1 2
    public boolean stoneGameBruteForce(int[] piles) {
        int sum = Arrays.stream(piles).sum();
        return recursion(Arrays.stream(piles).boxed().collect(LinkedList::new, LinkedList::add, LinkedList::addAll), sum, 0, true);
    }

    public boolean recursion(LinkedList<Integer> piles, int sum, int alix, boolean take) {
        if (piles.isEmpty()) {
            return alix > sum - alix;
        }
        LinkedList<Integer> left = new LinkedList<>(piles);
        int add = left.removeLast();
        boolean flag = recursion(left, sum, take ? alix + add : alix, !take);
        if (flag) return true;
        LinkedList<Integer> right = new LinkedList<>(piles);
        add = right.removeFirst();
        return recursion(right, sum, take ? alix + add : alix, !take);
    }

    public static void main(String[] args) {
        System.out.println(new StoneGame_877().stoneGame(new int[]{5,3,4,5}));
    }
}
