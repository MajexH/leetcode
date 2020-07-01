package arrayandstr;

import java.util.Arrays;

/**
 * @author majexh
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int last = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[last] != nums[fast]) {
                // 找到第一个不等的了
                nums[++last] = nums[fast];
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        return last + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{ 0,0,1,1,1,2,2,3,3,4 }));
    }
}
