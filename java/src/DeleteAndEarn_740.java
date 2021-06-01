import java.util.*;
import java.util.stream.Collectors;

public class DeleteAndEarn_740 {

    private static class Pair {
        int num;
        int counter;

        public Pair(int num, int counter) {
            this.num = num;
            this.counter = counter;
        }
    }

    // 选择一个数之后 会删除所选择的 +1 或者 -1 的数
    // 问最后能得到的最大结果是多少
    // 所以只需要用一个 int[i] 表示当前以当前数字结尾能够形成的最大结果
    public int deleteAndEarn(int[] nums) {
        // 统计 数字-出现次数 的键值对
        Map<Integer, Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e,
                        Collectors.reducing(0, e -> 1, Integer::sum)));
        List<Pair> pairList = new ArrayList<>();
        for (int key : map.keySet()) {
            pairList.add(new Pair(key, map.get(key)));
        }
        // 对其排序
        pairList.sort(Comparator.comparingInt(a -> a.num));

        int[] dp = new int[pairList.size()];
        // 不是顺序的 是 p.num +- 1
        for (int i = 0; i < dp.length; i++) {
            Pair p = pairList.get(i);
            if (i == 0) {
                dp[i] = p.num * p.counter;
                continue;
            }
            Pair pre = pairList.get(i - 1);
            if (pre.num + 1 == p.num) {
                // 不能要
                dp[i] = (i - 2 < 0 ? 0 : dp[i - 2]) + p.num * p.counter;
            } else {
                dp[i] = dp[i - 1] + p.num * p.counter;
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn_740().deleteAndEarn(new int[]{1}));
        System.out.println(new DeleteAndEarn_740().deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
