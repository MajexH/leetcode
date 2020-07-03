package math;

import java.util.Arrays;

public class AppearOnce {

    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        return Arrays.stream(nums).reduce((left, right) -> left ^ right).getAsInt();
    }
}
