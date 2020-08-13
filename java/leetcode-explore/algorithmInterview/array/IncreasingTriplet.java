package algorithmInterview.array;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] mins = new int[nums.length];
        mins[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i - 1]);
        }

        int[] maxs = new int[nums.length];
        maxs[nums.length - 1] = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            maxs[i] = Math.max(maxs[i + 1], nums[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mins[i] && nums[i] < maxs[i]) return true;
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

}
