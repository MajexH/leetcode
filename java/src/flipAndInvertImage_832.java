public class flipAndInvertImage_832 {

    public void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public void reverse(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1 - nums[i];
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] ints : A) {
            for (int m = 0, n = ints.length - 1; m < n; m++, n--) {
                swap(ints, m, n);
            }
            reverse(ints);
        }

        return A;
    }
}
