import java.util.Arrays;

/**
 * @author zhangminjie
 * @since 2021/8/11
 */
public class TriangleNumber_611 {

    // 找到能够形成三角形的组数
    public int triangleNumberBruteForce(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) res++;
                }
            }
        }
        return res;
    }

    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 既然是有序的 可以二分查找
                int sum = nums[i] + nums[j];
                int index = binarySearch(nums, sum, j);
                res += index - j;
            }
        }
        return res;
    }

    // 找到 num 的 最左位置减一的位置
    private int binarySearch(int[] nums, int num, int start) {
        int i = start + 1, j = nums.length - 1;
        int k = start;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (num <= nums[mid]) {
                j = mid - 1;
            } else {
                k = mid;
                i = mid + 1;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new TriangleNumber_611().triangleNumber(new int[]{1,1,3,4}));
    }
}
