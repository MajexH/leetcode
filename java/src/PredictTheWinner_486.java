import java.util.Arrays;

public class PredictTheWinner_486 {

    public boolean PredictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return recursionMemo(nums, 0, nums.length - 1, memo) >= 0;
    }

    public int recursionMemo(int[] nums, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return nums[i];
        if (memo[i][j] != -1) return memo[i][j];
        // 分别选取左边和右边的值进行比较
        int left = nums[i] - recursionMemo(nums, i + 1, j, memo);
        int right = nums[j] - recursionMemo(nums, i, j - 1, memo);
        memo[i][j] = Math.max(left, right);
        return memo[i][j];
    }

    // 两个人可以从数组两端取数字 那么第一个人是否能够获胜
    public boolean PredictTheWinnerBruteForce(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }

    public static void main(String[] args) {
        System.out.println(new PredictTheWinner_486().PredictTheWinner(new int[]{1, 5, 2}));
    }
}
