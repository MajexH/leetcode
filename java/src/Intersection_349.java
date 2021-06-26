import java.util.*;
import java.util.stream.Collectors;

public class Intersection_349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> map1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        Set<Integer> set = new HashSet<>();
        for (int j : nums2) {
            if (!map1.contains(j)) continue;
            set.add(j);
        }

        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }
}
