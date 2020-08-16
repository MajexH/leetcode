public class RemoveDuplicatesII_80 {

    // 排序数组 在原地删除数字
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int newIndex = 0, pre = 0, last = 0;
        while (last < nums.length) {
            int counter = 0;
            while (last < nums.length && nums[pre] == nums[last]) {
                last++;
                counter++;
            }
            for (int i = 0; i < Math.min(2, counter); i++) {
                nums[newIndex++] = nums[pre];
            }
            pre = last;
        }
        return newIndex;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesII_80().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
