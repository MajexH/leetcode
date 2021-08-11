import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangminjie
 * @since 2021/8/11
 */
public class NumberOfArithmeticSlicesII_446 {

    public int numberOfArithmeticSlices(int[] nums) {
        // 长度 - 形成的等差子序列数量
        List<Map<Long, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dp.add(new HashMap<>());
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                // 前面 diff 有多少个形成的
                int pre = dp.get(j).getOrDefault(diff, 0);
                res += pre;
                // 在前面形成 diff 且数量为 pre 情况下 相当于 机上 pre 个 diff 并且
                dp.get(i).put(diff, dp.get(i).getOrDefault(diff, 0) + pre + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlicesII_446().numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
        System.out.println(new NumberOfArithmeticSlicesII_446().numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(new NumberOfArithmeticSlicesII_446().numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));

    }
}
