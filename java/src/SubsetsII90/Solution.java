package SubsetsII90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursion(nums, 0, res, new LinkedList<>());
        return res;
    }

    public void recursion(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            // 这种解法不能避免有两个相同的最小生成的重复
            if (canGenerate(nums, index, i)) {
                temp.add(nums[i]);
                recursion(nums, i + 1, res, temp);
                temp.removeLast();
            }
        }
    }

    public boolean canGenerate(int[] nums, int start, int end) {
        while (start < end) {
            // 有相同的说明已经生成过了
            if (nums[start++] == nums[end]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{4,4,4,1,1,4}));
    }
}
