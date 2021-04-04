public class NumSubarrayProductLessThanK_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int l = 0, r = 0;
        int multi = 1;
        while (r < nums.length) {
            multi *= nums[r];
            while (l <= r && multi >= k) {
                multi /= nums[l++];
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumSubarrayProductLessThanK_713().numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
    }
}
