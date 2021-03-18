import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysWithKDistinct_992 {

    // 如果 A 里面
    public int subarraysWithKDistinct(int[] A, int K) {
        return subArraysDistinctAtMostK(A, K) - subArraysDistinctAtMostK(A, K - 1);
    }

    // 计算最多的有多少个的话 可以固定左边界 然后计算
    private int subArraysDistinctAtMostK(int[] array, int k) {
        Map<Integer, Integer> window = new HashMap<>();

        int res = 0;

        int left = 0, right = 0;

        while (right < array.length) {
            // 固定左边界 移动右边界
            window.put(array[right], window.getOrDefault(array[right], 0) + 1);
            // 这边已经需要减除了
            while (left <= right && window.size() > k) {
                window.put(array[left], window.get(array[left]) - 1);
                if (window.get(array[left]) == 0) window.remove(array[left]);
                left++;
            }
            // 这个地方是因为右边界到左边之间的数字 一定是小于等于 K 个不同的数字的
            // 那么能够以左边界形成的 一定是中的一个子数组 如
            // 以 [1,2,1,2,3] 为例，左边界固定的时候，恰好存在 2 个不同整数的子区间为 [1,2],[1,2,1],[1,2,1,2]，总数为 3。其值为下标 3 - 1 + 1，即区间 [1..3] 的长度。
            res += right - left;
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraysWithKDistinct_992().subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
        System.out.println(new SubarraysWithKDistinct_992().subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }
}
