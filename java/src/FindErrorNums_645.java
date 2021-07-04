import java.util.Arrays;

public class FindErrorNums_645 {

    public int[] findErrorNums(int[] nums) {
        if (nums.length == 0) return new int[0];

        int duplicated = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = i + 1;
            while (nums[i] != current) {
                if (nums[nums[i] - 1] == nums[i]) {
                    duplicated = nums[i];
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        int sum = Arrays.stream(nums).sum();
        return new int[]{duplicated, (nums.length + 1) * nums.length / 2 - sum + duplicated};
    }

    private void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindErrorNums_645().findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(new FindErrorNums_645().findErrorNums(new int[]{1, 1})));
    }
}
