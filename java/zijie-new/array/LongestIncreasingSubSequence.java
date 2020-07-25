package array;

public class LongestIncreasingSubSequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curLength = 0, maxLength = 0;
        Integer pre = null;
        for (int num : nums) {
            if (pre == null || num > pre) {
                curLength++;
            } else {
                curLength = 1;
            }
            pre = num;
            maxLength = Math.max(maxLength, curLength);
        }

        return maxLength;
    }
}
