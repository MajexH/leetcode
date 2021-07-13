import java.util.Arrays;

public class LengthOfLongestSubstring_48 {

    public int lengthOfLongestSubstring(String s) {
        int[] preIndexes = new int[255];
        Arrays.fill(preIndexes, -1);

        int res = 0, len = 0;

        for (int i = 0; i < s.length(); i++) {
            // 在当前距离之外 或者 没有访问过
            if (preIndexes[s.charAt(i)] == -1 || i - preIndexes[s.charAt(i)] > len) {
                len++;
            } else {
                // 在当前距离之类
                len = i - preIndexes[s.charAt(i)];
            }
            res = Math.max(res, len);
            preIndexes[s.charAt(i)] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring_48().lengthOfLongestSubstring("pwwkew"));
    }
}
