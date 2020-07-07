package arrayandstr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // 因为这儿要返回数组的原序列 因此不能排序之后再去寻找
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{ i, j };
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           if (map.containsKey(target - nums[i])) {
               return new int[]{ i, map.get(target - nums[i]) };
           }
           // 这儿必须这么放 这样可以保证重复数字情况下也能找到
           map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
    }
}
