package str;

import java.util.Arrays;

/**
 * @author majexh
 */
public class MaxNotDuplicatedString {

    public int lengthOfLongestSubstring(String s) {
        // 记录这个字符上一次出现的位置
        int[] memo = new int[255];
        Arrays.fill(memo, -1);
        // 保存最大长度
        int maxLength = 0, currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (memo[character] != -1) {
                // 如果重复的超出了 当前长度 则这个重复再当前的字符串里面 是没有重复的
                if (i - memo[character] > currentLength) {
                    currentLength++;
                } else {
                    maxLength = Math.max(maxLength, currentLength);
                    // 说明这个时候 要将当前字符串 移动到 上一个重复的字符串后面一个
                    currentLength = i - memo[character];
                }
            } else {
                currentLength++;
            }
            memo[character] = i;
        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNotDuplicatedString().lengthOfLongestSubstring("awwpwke"));
    }
}
