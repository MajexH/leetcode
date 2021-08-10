/**
 * @author zhangminjie
 * @since 2021/8/10
 */
public class NumberOfArithmeticSlices_413_new {

    /**
     * 滑动窗口的问题
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int res = 0;

        int left = 0, right = 1;
        while (right < nums.length) {
            int diff = nums[right] - nums[right - 1];
            while (right < nums.length && nums[right] - nums[right - 1] == diff) {
                right++;
                if (right + 1 - left >= 3) {
                    // right 在最后一个
                    res += right - left - 2;
                }
            }
            // 重新定位 left 到 right 前一个
            // 因为现在这两个仍然可能和后面的位置形成等差数列
            left = right - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices_413_new().numberOfArithmeticSlices(new int[]{1, 2, 3}));
        System.out.println(new NumberOfArithmeticSlices_413_new().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(new NumberOfArithmeticSlices_413_new().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
    }
}
