package array;

public class LongestContinusSequenceNew {

    // 寻找最长的连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        // 这是不存在的
        if (nums == null || nums.length == 0) return 0;
        int currentLength = 0, pre = Integer.MIN_VALUE, maxLength = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > pre) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            pre = num;
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
