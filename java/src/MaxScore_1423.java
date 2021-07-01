import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxScore_1423 {

    // 因为是从前后取 所以是看中间的 n - k 个数 能够形成的最小大小
    public int maxScore(int[] cardPoints, int k) {
       if (k == 0 || cardPoints.length == 0) return 0;
       int total = Arrays.stream(cardPoints).sum();
       if (k >= cardPoints.length) return total;

       int len = cardPoints.length - k;
       int minSum = Integer.MAX_VALUE;
       int[] sum = new int[cardPoints.length];
       sum[0] = cardPoints[0];
       for (int i = 1; i < cardPoints.length; i++) {
           sum[i] = sum[i - 1] + cardPoints[i];
       }

       for (int i = 0; i <= cardPoints.length - len; i++) {
           minSum = Math.min(minSum, sum[i + len - 1] - (i >= 1 ? sum[i - 1]: 0));
       }

       return total - minSum;
    }


    // 模拟的结果并不好 会超时 因为会形成一棵树 2^n
    public int maxScoreBruteForce(int[] cardPoints, int k) {
        if (k >= cardPoints.length) {
            return Arrays.stream(cardPoints).reduce(0, Integer::sum);
        }
        return recursion(cardPoints, k, 0, cardPoints.length - 1, new HashMap<>());
    }

    // 那这样的话 是不是可以用 left, right 就可以知道已经取了几个数了
    private int recursion(int[] cardPoints, int k, int left, int right, Map<String, Integer> memo) {
        if (k == 0) {
            return 0;
        }
        String key = String.format("%d_%d_%d", k, left, right);
        if (memo.containsKey(key)) return memo.get(key);
        int maxLeft = recursion(cardPoints, k - 1, left + 1, right, memo) + cardPoints[left];
        int maxRight = recursion(cardPoints, k - 1, left, right - 1, memo) + cardPoints[right];
        memo.put(key, Math.max(maxLeft, maxRight));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(new MaxScore_1423().maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}
