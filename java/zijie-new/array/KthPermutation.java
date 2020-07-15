package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermutation {

    public int[] getFactorials(int n) {
        int[] factorials = new int[n];
        // 0! = 1
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        return factorials;
    }

    public String recursion(int n, int k, boolean[] used, int[] factorials, int[] nums, int depth, List<String> temp) {
        if (depth == n) {
            return String.join("", temp);
        }
        // 获取当前的排列数
        // 即每层有多少个
        int fac = factorials[n - depth - 1];
        for (int i = 0; i < n; i++) {
            // 当前元素被使用过
            if (used[i]) continue;
            if (fac < k) {
                // 当前的排列数小于需要找的排列数
                // 就需要去寻找下一个开头的 一组排列
                k -= fac;
                continue;
            }
            temp.add(String.valueOf(nums[i]));
            used[i] = true;
            return recursion(n, k, used, factorials, nums, depth + 1, temp);
        }
        // 找不到
        return null;
    }

    public String getPermutation(int n, int k) {
        int[] factorials = getFactorials(n);
        // 保存所有的数字
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return recursion(n, k, new boolean[n], factorials, nums, 0, new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println(new KthPermutation().getPermutation(4,3));
    }
}
