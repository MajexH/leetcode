public class MinSubArrayLen_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right++];
            while (left <= right && sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen_209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new MinSubArrayLen_209().minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(new MinSubArrayLen_209().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
