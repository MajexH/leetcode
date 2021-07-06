public class MajorityElement_39 {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int num = nums[0], counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) counter++;
            else if (counter > 0) counter--;
            else {
                num = nums[i];
                counter = 1;
            }
        }
        return num;
    }
}
