package chapter6;

public class MissingNumber_53_1 {

    // 长度为 n - 1 的数组 里面的数字范围从 0 - n
    // 其中有一个数字缺失了 问缺失的数字是啥
    public int missingNumber(int[] nums) {
        // 数字应该与自己的下标吻合
        int i = 0, j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (mid != nums[mid]) {
                // 这个地方可以判断 是否是第一个下标和数字不等的 可以减少循环
                if (mid == 0 || nums[mid - 1] == nums[mid]) return mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber_53_1().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }
}
