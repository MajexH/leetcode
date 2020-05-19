import java.util.Arrays;

public class DeleteDuplicateInSorted {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int last = 0, fast = 1;
        int res = 1;
        while (fast < nums.length) {
            if (nums[last] != nums[fast]) {
                nums[res++] = nums[fast];
                last = fast;
            }
            fast++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{ 0,0,1,1,1,2,2,3,3,4 };
        System.out.println(new DeleteDuplicateInSorted().removeDuplicates(test));
        System.out.println(Arrays.toString(test));
    }
}
