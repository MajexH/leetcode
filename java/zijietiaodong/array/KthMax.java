package array;

public class KthMax {

    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i < nums.length && nums[i] > base) if (i == end) break;
            while (nums[--j] < base) if (j == start) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new KthMax().findKthLargest(new int[]{ 3,2,1,5,6,4 }, 3));
    }
}
