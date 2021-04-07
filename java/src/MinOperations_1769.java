import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinOperations_1769 {

    // 如果能够统一一个数左侧有多少个 1 右侧有多少个 1
    // 那么转移到下一个数的时候 左侧的相当于都要 +1 右侧的所有 都要 -1
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        if (boxes.length() == 0) return res;
        int left = boxes.charAt(0) == '1' ? 1 : 0;
        // total 为所有的数据转移到当前位置需要的操作数
        int right = 0, total = 0;
        // 初始化
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                // 因为初始化统计 i == 0 时要转移的次数 所以直接 ++
                total += i;
                right++;
            }
        }
        // 已经统计完 res 需要转移的数量
        res[0] = total;
        for (int i = 1; i < res.length; i++) {
            // 从上一个状态转移到这儿的时候 左侧的要增加 右侧的要减少
            total = total + left - right;
            res[i] = total;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
        }

        return res;
    }

    // o(n ^ 2) 的解法
    public int[] minOperationsBruteForce(String boxes) {
        int[] res = new int[boxes.length()];
        Set<Integer> memo = new HashSet<>();

        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                memo.add(i);
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int index : memo) {
                res[i] += Math.abs(index - i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MinOperations_1769().minOperations("001011")));
    }
}
