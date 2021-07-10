import java.util.Arrays;

public class MajorityElement_17_10 {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int num = nums[0], counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) counter++;
            else if (counter > 0) counter--;
            else {
                num = nums[i];
                counter = 1;
            }
        }
        // 还要看是否超过一半的大小
        counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) counter++;
        }
        return counter >= Math.ceil(nums.length / 2D) ? num : -1;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement_17_10().majorityElement(new int[]{1,2,3}));
    }
}
