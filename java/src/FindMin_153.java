public class FindMin_153 {

    public int findMin(int[] nums) {

        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else if (nums[mid] < nums[i]) {
                j = mid;
            } else {
                return nums[i];
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new FindMin_153().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new FindMin_153().findMin(new int[]{11,13,15,17}));
    }
}
