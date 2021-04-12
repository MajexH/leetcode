import java.util.Arrays;

public class LargestNumber_179 {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        String res = String.join("", strs);
        int i = 0;
        while (i < res.length()) {
            if (res.charAt(i) != '0') break;
            i++;
        }
        if (i == res.length()) return "0";
        return res.substring(i);
    }
}
