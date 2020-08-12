package algorithmInterview.sort;

import java.util.Arrays;

public class MaxNumber {
    public String largestNumber(int[] nums) {
        if (nums == null) return "";
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, (a, b) -> (b + a).compareTo(a + b));
        String res = String.join("", asStrs);
        return res.charAt(0) == '0' ? "0" : res;
    }
}
