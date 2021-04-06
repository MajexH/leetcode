import java.util.HashMap;
import java.util.Map;

public class CountNicePairs_1814 {

    public int countNicePairs(int[] nums) {
        long res = 0;
        Map<Integer, Long> memo = new HashMap<>();
        // 这道题其实就是计算组合数
        for (int num : nums) {
            int key = num - rev(num);
            memo.put(key, memo.getOrDefault(key, 0L) + 1);
        }
        for (int key : memo.keySet()) {
            long t = memo.get(key);
            res = (res + t * (t - 1) / 2) % 1000000007;
        }
        return (int) res;
    }

    public int rev(int num) {
        int res = 0;
        while (num != 0) {
            res *= 10;
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountNicePairs_1814().countNicePairs(new int[]{42, 11, 1, 97, 210}));
        System.out.println(new CountNicePairs_1814().countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }
}
