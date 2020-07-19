package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermutationNew {

    public String recursion(int[] nums, int[] factorial, boolean[] used, int n, int k, List<String> temp) {
        if (n == 0) {
            return String.join("", temp);
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (k > factorial[n - 1]) {
                k -= factorial[n - 1];
                continue;
            }
            used[i] = true;
            temp.add(String.valueOf(nums[i]));
            return recursion(nums, factorial, used, n - 1, k, temp);
        }
        return null;
    }

    public String getPermutation(int n, int k) {
        // 构造形成排列的数字的集合
        int[] nums = new int[n];
        // 构造一个阶乘的数组
        int[] factorial = new int[n];
        factorial[0] = 1;

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            if (i == 0) continue;
            factorial[i] = factorial[i - 1] * i;
        }

        return recursion(nums, factorial, new boolean[nums.length], n, k, new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println(new KthPermutationNew().getPermutation(4,9));
    }
}
