public class FindPeak_162 {

    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (mid == nums.length - 1) return mid;
            if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new FindPeak_162().findPeakElement(new int[]{1,2,3,1}));
    }
}
