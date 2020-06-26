package array;

/**
 * @author majexh
 */
public class LongestIncreasingSubArray {

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        int currentLength = 0;
        int pre = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > pre) {
                currentLength++;
            } else {
                maxLength = Math.max(currentLength, maxLength);
                currentLength = 1;
            }
            pre = num;
        }

        return Math.max(currentLength, maxLength);
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubArray().findLengthOfLCIS(new int[]{ 2,2,2,2 }));
    }
}
