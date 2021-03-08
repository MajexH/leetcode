package algorithmInterview.heapAndStackAndQueue;

public class KthMax {

    public int findKthLargest(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        int index = partition(nums, i, j);
        while (index != k - 1) {
            if (index > k - 1) {
                j = index - 1;
            } else {
                i = index + 1;
            }
            index = partition(nums, i, j);
        }
        return nums[k - 1];
    }

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;

        while (true) {
            i++;
            while (i <= end && nums[i] > base) {
                i++;
            }
            j--;
            while (j >= start && nums[j] < base) {
                j--;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
