package math;

public class MajorityNumber {

    // majorityElement 指的是一个数组中元素超过一半的数字
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int number = nums[0], counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == number) {
                counter++;
            } else if (counter == 0) {
                number = nums[i];
                counter = 1;
            } else {
                counter--;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityNumber().majorityElement(new int[]{ 2,2,1,1,1,2,2,1,1 }));
    }
}
