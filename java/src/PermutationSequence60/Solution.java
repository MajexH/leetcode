package PermutationSequence60;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        int[] sum = new int[n];
        sum[0] = 1;
        get(n - 1, sum);
        // 用k-1的目的是因为 在nums里面对应的k的位置是需要减一的
        return recursion(nums, k - 1, n, sum);
    }

    public void get(int n, int[] res) {
        if (n == 1 || n == 0) {
            res[n] = 1;
            return;
        }
        get(n - 1, res);
        res[n] = n * res[n - 1];
    }

    public String recursion(List<Integer> nums, int k, int n, int[] sums) {
        // 计算当前位置
        if (n == 0) {
            return "";
        }
        int index = k / (sums[n - 1]);

        String temp = nums.get(index).toString();
        nums.remove(index);
        return temp + recursion(nums, k % (sums[n - 1]), n - 1, sums);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(1, 1));
    }
}
