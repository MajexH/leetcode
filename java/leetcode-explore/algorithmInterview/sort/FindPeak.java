package algorithmInterview.sort;

public class FindPeak {

    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j - 1) {
            int mid = (i + j) / 2;
            if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i] > nums[j] ? i : j;
    }
}
