package array;

public class LongestContinusSequence {

    public int findLengthOfLCIS(int[] nums) {
        int pre = -1;
        int maxLength = 0, curLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pre == -1 || nums[i] > nums[pre]) {
                curLength++;
            } else {
                curLength = 1;
            }
            pre = i;
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestContinusSequence().findLengthOfLCIS(new int[]{2,2,2,2}));
    }
}
