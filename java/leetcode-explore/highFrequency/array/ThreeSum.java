package highFrequency.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // 既然不能用 recursion 也就意味着
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 跳过相等的数字
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];

            for (int l = i + 1, r = nums.length - 1; l < r; ) {
                int sum = nums[l] + nums[r];

                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    // 等于
                    int finalI = i;
                    int finalL = l;
                    int finalR = r;
                    res.add(new ArrayList<>() {{
                        add(nums[finalI]);
                        add(nums[finalL]);
                        add(nums[finalR]);
                    }});
                    // 跳过相等的数字
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                }
            }
        }

        return res;
    }

    // recursion 超时
    public List<List<Integer>> threeSumWithRecursion(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        recursion(res, new ArrayList<>(), 0, nums, 0);
        return res;
    }

    public void recursion(List<List<Integer>> res, List<Integer> tmp, int start, int[] nums, int target) {
        if (tmp.size() == 3) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (canGenerate(nums, start, i)) {
                tmp.add(nums[i]);
                recursion(res, tmp, i + 1, nums, target - nums[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean canGenerate(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }
}
