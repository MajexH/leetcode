public class ShortestUnsortedContinuousSubarray_581 {

    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        // 保证顺序的时候其返回值是0
        int right = -2, left = -1;
        // 从左向右 找到最后一个逆序 这个逆序只要是 这个数比前面记录的最大值小 就是
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) right = i;
        }
        // 跟上面相反
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) left = i;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray_581().findUnsortedSubarray(new int[]{ 1,2,3 }));
    }
}
