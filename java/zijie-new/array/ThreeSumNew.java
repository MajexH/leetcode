package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author majexh
 */
public class ThreeSumNew {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i >= 1 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int temp = nums[left] + nums[right];
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;
                } else {
                    // 等于
                    List<Integer> tempRes = new ArrayList<>();
                    tempRes.add(nums[i]);
                    tempRes.add(nums[left]);
                    tempRes.add(nums[right]);
                    res.add(tempRes);
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumNew().threeSum(new int[]{ 0,0,0 }));
    }
}
