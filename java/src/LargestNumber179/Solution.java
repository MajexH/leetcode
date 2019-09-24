package LargestNumber179;

import java.util.Arrays;
import java.util.Comparator;

// 全排列的局限性还是很大的 因为全排列需要遍历所有的可能 所有如果数组长度过大 可能超时
public class Solution {

    public String largestNumber1(int[] nums) {
        return recursion(nums, 0);
    }

    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, (String a, String b) -> (b + a).compareTo(a + b));
        if (asStrs[0].equals("0")) {
            return "0";
        }
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    public String recursion(int[] nums, int start) {
        if (start == nums.length) {
            StringBuilder builder = new StringBuilder();
            for (int temp : nums) {
                builder.append(temp);
            }
            return builder.toString();
        }
        String max = "0";
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            max = max(max, recursion(nums, start + 1));
            swap(nums, start, i);
        }
        return max;
    }

    public String max(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            int i1 = Integer.parseInt(a.substring(i, i + 1));
            int i2 = Integer.parseInt(b.substring(j, j + 1));
            if (i1 > i2) {
                return a;
            } else if (i1 < i2) {
                return b;
            } else {
                i++;
                j++;
            }
        }
        return a;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{ 999999998,999999997,999999999 }));
    }
}
