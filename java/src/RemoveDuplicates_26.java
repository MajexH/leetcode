public class RemoveDuplicates_26 {
    // 只出现一次 删除到
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            if (fast == nums.length) break;
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates_26().removeDuplicates(new int[]{1,1}));
    }
}
