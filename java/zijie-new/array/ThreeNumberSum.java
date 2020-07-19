package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int tempSum = nums[left] + nums[right];
                if (tempSum < target) left++;
                else if (tempSum > target) right--;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (right > left && nums[right] == nums[right + 1]);
                }
            }
        }

        return res;
    }
}
