import java.util.Arrays;

public class SingleNumber_III {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[2];
        // 因为有两个数不用 那么 亦或结果一定不为 0 那么就可以计算出在哪一位上 这两个数不同
        int xor = Arrays.stream(nums).reduce((left, right) -> left ^ right).getAsInt();

        int counter = 0;
        while ((xor & 1) == 0) {
            xor >>= 1;
            counter++;
        }

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if (((num >> counter) & 1) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumber_III().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(new SingleNumber_III().singleNumber(new int[]{-1, 0})));
        System.out.println(Arrays.toString(new SingleNumber_III().singleNumber(new int[]{1, 0})));
    }
}
