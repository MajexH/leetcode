import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // 初始化
        int abs = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 避免重复 查找
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int findTarget = target - nums[i];
            int front = i + 1, end = nums.length - 1;
            while (front < end) {
                int tempSum = nums[front] + nums[end];
                // 如果现在保存的 与 target 这个数的距离 比现在遍历到的大
                // 说明 现在遍历的这个结果 应该 最后的结果跟 target 最接近 更新结果
                if (abs > Math.abs(findTarget - tempSum)) {
                    abs = Math.abs(findTarget - tempSum);
                    res = target - findTarget + tempSum;
                }
                if (tempSum > findTarget) {
                    end--;
                } else if (tempSum < findTarget) {
                    front++;
                } else {
                    // 这个地方是找到相等的了
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{ -3,-2,-5,3,-4 }, -1));
    }
}
