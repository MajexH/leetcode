import java.util.HashMap;

public class FindtheDuplicateNumber_287 {

    public int getCount(int[] nums, int start, int end) {
        int res = 0;
        for (int num : nums) {
            if (num >= start && num <= end) res++;
        }
        return res;
    }

    public int findDuplicate(int[] nums) {
        int i = 1, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            int count = getCount(nums, i, mid);
            if (count > mid - i + 1) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new FindtheDuplicateNumber_287().findDuplicate(new int[]{ 1,3,4,2,2 }));
    }
}
