public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0, left = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == s ? 1 : 0;
        int res = Integer.MAX_VALUE;
        int last = 0, fast = 1;
        if (nums[last] >= s) {
            res = 1;
        }
        int sum = nums[last] + nums[fast];

        while (last < nums.length) {
            if (sum >= s) res = Math.min(res, fast - last + 1);
            while (sum >= s && last < fast) {
                sum -= nums[last++];
                if (sum >= s)
                    res = Math.min(res, fast - last + 1);
            }
            fast++;
            if (fast >= nums.length) break;
            sum += nums[fast];
        }
        while (last < fast) {
            sum -= nums[last++];
            if (sum >= s) res = Math.min(res, fast - last + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum_209().minSubArrayLen(3, new int[]{ 1,1 }));
    }
}
