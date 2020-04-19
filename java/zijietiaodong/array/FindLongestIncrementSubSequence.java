package array;

public class FindLongestIncrementSubSequence {

    public int findLengthOfLCIS(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int curCounter = 0;
        int max = 0;
        for (int num : nums) {
            if (num > pre) {
                curCounter++;
            } else {
                curCounter = 1;
            }
            pre = num;
            max = Math.max(max, curCounter);
        }
        return max;
    }
}
