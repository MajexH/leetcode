public class CanBeIncreasing_1909 {

    public boolean canBeIncreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                boolean flag = false;
                if (i + 1 < nums.length) {
                    flag = nums[i - 1] < nums[i + 1] && canBeIncreasing(nums, i + 1);
                } else {
                    // 一直都是升序的
                    return true;
                }
                if (flag) return true;

                if (i - 2 >= 0) {
                    flag = nums[i - 2] < nums[i] && canBeIncreasing(nums, i);
                } else {
                    flag = canBeIncreasing(nums, i);
                }
                return flag;
            }
        }
        return true;
    }

    private boolean canBeIncreasing(int[] nums, int first) {

        for (int i = first + 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanBeIncreasing_1909().canBeIncreasing(new int[]{512,867,904,997,403}));
        System.out.println(new CanBeIncreasing_1909().canBeIncreasing(new int[]{105,924,32,968}));
        System.out.println(new CanBeIncreasing_1909().canBeIncreasing(new int[]{100, 21, 100}));
        System.out.println(new CanBeIncreasing_1909().canBeIncreasing(new int[]{1, 2, 10, 1, 2}));
        System.out.println(new CanBeIncreasing_1909().canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
    }
}
