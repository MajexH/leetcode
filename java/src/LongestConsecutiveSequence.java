import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int temp = num + 1;
                int tempRes = 1;
                while (set.contains(temp)) {
                    tempRes++;
                    set.remove(temp);
                    temp++;
                }
                temp = num - 1;
                while (set.contains(temp)) {
                    tempRes++;
                    set.remove(temp);
                    temp--;
                }
                res = Math.max(res, tempRes);
            }
        }
        return res;
    }
}
