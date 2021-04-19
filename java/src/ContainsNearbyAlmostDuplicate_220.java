import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate_220 {

    // 因为数值太大了 其找的有只是个范围 所以直接用 bst 的方法来访问即可
    // 滑动一个 k 的大小即可
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }

            set.add((long) nums[i]);

            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
