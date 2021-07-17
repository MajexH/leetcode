public class Search_53_I {

    // 找到一个数字在排序的 nums 中出现的次数
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = leftSearch(nums, target);
        if (left == -1) return 0;
        return rightSearch(nums, target) - left + 1;
    }

    public int leftSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i] == target ? i : -1;
    }

    public int rightSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = (i + j + 1) / 2;

            if (target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        return nums[i] == target ? i : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search_53_I().search(new int[]{2,2}, 2));
    }
}
