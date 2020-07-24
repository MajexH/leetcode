package chapter2.array;

public class FindDuplicateInArrayWithoutChange4 {

    /**
     * 一个长度为 n + 1 的数组上 所有的数字都在 1 - n 的范围里
     * 所以至少有一个数字是重复的，找出一个重复的数字即可
     * @param nums
     * @return
     */
    public int findDuplicateInArrayWithoutChange(int[] nums) {
        // i j 代表的最大和最小的数
        int i = 1, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            int counterMid = countNumber(nums, i, mid);
            if (counterMid > mid - i + 1) {
                j = mid;
            } else {
                // 小于等于的话 一定是在右边
                i = mid + 1;
            }
        }
        if (countNumber(nums, i, j) == 1) return -1;
        else return i;
    }

    /**
     * 找到这个数组里面所有大于 min 并且小于 max 的数的数量
     * @param nums
     * @param min
     * @param max
     * @return
     */
    public int countNumber(int[] nums, int min, int max) {
        int res = 0;
        for (int num : nums) {
            if (num >= min && num <= max) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateInArrayWithoutChange4().findDuplicateInArrayWithoutChange(new int[]{2,3,5,4,3,2,6,7}));
    }
}
