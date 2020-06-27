package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSequence {

    public int longestConsecutive(int[] nums) {
        int maxLength = 0;

        Set<Integer> memo = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            if (memo.contains(num)) {
                int length = 1;
                int temp = num + 1;
                memo.remove(num);
                while (memo.contains(temp)) {
                    memo.remove(temp);
                    temp++;
                    length++;
                }
                temp = num - 1;
                while (memo.contains(temp)) {
                    memo.remove(temp);
                    temp--;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSequence().longestConsecutive(new int[]{ 1,2,3,4,100,200 }));
    }
}
